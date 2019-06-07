package com.ebs.publisher;

import com.ebs.publisher.protogen.Pub;
import com.ebs.publisher.service.Publication;
import com.ebs.publisher.service.PublicationGenerator;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String ip = "127.0.0.1";
        String port = "8890";
        int pubGenCount = Integer.parseInt("100");
        String endpoint = "/public/publish";
        StringBuilder builder = new StringBuilder("http://");
        builder.append(ip);
        builder.append(":");
        builder.append(port);
        builder.append(endpoint);

        String url = builder.toString();

        for (int i = 0; i < pubGenCount; i++) {
            Publication publication = new PublicationGenerator().generatePublication();
            Pub.Publication.Builder pubBuilder = Pub.Publication.newBuilder();
            pubBuilder.setDateOfBirth(publication.getDateOfBirth());
            pubBuilder.setEyeColor(publication.getEyeColor());
            pubBuilder.setHeartRate(publication.getHeartRate());
            pubBuilder.setPatientName(publication.getPatientName());
            pubBuilder.setHeight(publication.getHeight());
            System.out.println("Sending: "+publication.toString());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                pubBuilder.build().writeTo(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String publcationAsString = new String(outputStream.toByteArray());
            MultiValueMap<String,String> headers = new HttpHeaders();
            List<String> list = new ArrayList<String>();
            try {
                list.add(Inet4Address.getLocalHost().getHostAddress());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            headers.put("client_ip",list);
            HttpEntity<String> request = new HttpEntity<>(publcationAsString,headers);
            try{
                restTemplate.postForObject(url, request, String.class);
            }catch(ResourceAccessException ignored){

            }
        }
    }
}
