package com.ebs.subscriber.events;

import com.ebs.subscriber.model.pojo.Subscription;
import com.ebs.subscriber.model.pojo.SubscriptionProperty;
import com.ebs.subscriber.model.protogen.Sub;
import com.ebs.subscriber.service.ConverterService;
import com.ebs.subscriber.service.generator.SubscriptionGenerator;
import com.ebs.subscriber.service.generator.fields.FieldFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
  private RestTemplate restTemplate = new RestTemplate();
  private static FieldFactory fieldFactory = new FieldFactory();

  @Value("${subNumber}")
  private int subNumber;

  @Value("${patientNamePercentage}")
  private int patientNamePercentage;

  @Value("${dateOfBirthPercentage}")
  private int dateOfBirthPercentage;

  @Value("${heightPercentage}")
  private int heightPercentage;

  @Value("${eyeColorPercentage}")
  private int eyeColorPercentage;

  @Value("${heartRatePercentage}")
  private int heartRatePercentage;

  @Value("${patientNameEqualityPercentage}")
  private int patientNameEqualityPercentage;

  @Value("${dateOfBirthEqualityPercentage}")
  private int dateOfBirthEqualityPercentage;

  @Value("${heightEqualityPercentage}")
  private int heightEqualityPercentage;

  @Value("${eyeColorEqualityPercentage}")
  private int eyeColorEqualityPercentage;

  @Value("${heartRateEqualityPercentage}")
  private int heartRateEqualityPercentage;

  @Value("${destination}")
  private String destination;

  @Autowired Environment environment;

  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {

    if (patientNameEqualityPercentage
            + dateOfBirthEqualityPercentage
            + heightEqualityPercentage
            + eyeColorEqualityPercentage
            + heartRateEqualityPercentage
        < 100) {
      System.out.println("Percentages do not add up to 100%");
    } else {
      SubscriptionGenerator generator = new SubscriptionGenerator();
      generator.setPatientNamePercentage(patientNamePercentage);
      generator.setDateOfBirthPercentage(dateOfBirthPercentage);
      generator.setEyeColorPercentage(eyeColorPercentage);
      generator.setHeartRatePercentage(heartRatePercentage);
      generator.setHeightPercentage(heightPercentage);
      generator.setPatientNameEqualityPercentage(patientNameEqualityPercentage);
      generator.setDateOfBirthEqualityPercentage(dateOfBirthEqualityPercentage);
      generator.setHeightEqualityPercentage(heightEqualityPercentage);
      generator.setEyeColorEqualityPercentage(eyeColorEqualityPercentage);
      generator.setHeartRateEqualityPercentage(heartRateEqualityPercentage);
      ArrayList<Subscription> subscriptions = generator.generate(subNumber);
      for (Subscription subscription : subscriptions) {
        send(subscription);
      }
    }
  }

  public void send(Subscription subscription) {
    String subscriptionAsString = ConverterService.getProtoStringFromSubscription(subscription);

    MultiValueMap<String, String> headers = new HttpHeaders();
    List<String> list = new ArrayList<String>();
    try {
      list.add(
          Inet4Address.getLocalHost().getHostAddress()
              + ":"
              + environment.getProperty("local.server.port"));
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    headers.put("client_ip", list);
    HttpEntity<String> request = new HttpEntity<>(subscriptionAsString, headers);
    try {
      System.out.println("Subscribing with: " + subscription.toString());
      restTemplate.postForObject(destination, request, String.class);
    } catch (ResourceAccessException ignored) {

    }
  }
}
