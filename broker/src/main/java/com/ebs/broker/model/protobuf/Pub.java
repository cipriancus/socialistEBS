// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pub.proto

package com.ebs.broker.model.protobuf;

public final class Pub {
  private Pub() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PublicationOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.ebs.broker.model.protobuf.Publication)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string patientName = 1;</code>
     */
    java.lang.String getPatientName();
    /**
     * <code>string patientName = 1;</code>
     */
    com.google.protobuf.ByteString
        getPatientNameBytes();

    /**
     * <code>string dateOfBirth = 2;</code>
     */
    java.lang.String getDateOfBirth();
    /**
     * <code>string dateOfBirth = 2;</code>
     */
    com.google.protobuf.ByteString
        getDateOfBirthBytes();

    /**
     * <code>string height = 3;</code>
     */
    java.lang.String getHeight();
    /**
     * <code>string height = 3;</code>
     */
    com.google.protobuf.ByteString
        getHeightBytes();

    /**
     * <code>string eyeColor = 4;</code>
     */
    java.lang.String getEyeColor();
    /**
     * <code>string eyeColor = 4;</code>
     */
    com.google.protobuf.ByteString
        getEyeColorBytes();

    /**
     * <code>string heartRate = 5;</code>
     */
    java.lang.String getHeartRate();
    /**
     * <code>string heartRate = 5;</code>
     */
    com.google.protobuf.ByteString
        getHeartRateBytes();
  }
  /**
   * Protobuf type {@code com.ebs.broker.model.protobuf.Publication}
   */
  public  static final class Publication extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.ebs.broker.model.protobuf.Publication)
      PublicationOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Publication.newBuilder() to construct.
    private Publication(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Publication() {
      patientName_ = "";
      dateOfBirth_ = "";
      height_ = "";
      eyeColor_ = "";
      heartRate_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Publication(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              patientName_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              dateOfBirth_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              height_ = s;
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              eyeColor_ = s;
              break;
            }
            case 42: {
              java.lang.String s = input.readStringRequireUtf8();

              heartRate_ = s;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ebs.broker.model.protobuf.Pub.internal_static_com_ebs_broker_model_protobuf_Publication_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ebs.broker.model.protobuf.Pub.internal_static_com_ebs_broker_model_protobuf_Publication_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ebs.broker.model.protobuf.Pub.Publication.class, com.ebs.broker.model.protobuf.Pub.Publication.Builder.class);
    }

    public static final int PATIENTNAME_FIELD_NUMBER = 1;
    private volatile java.lang.Object patientName_;
    /**
     * <code>string patientName = 1;</code>
     */
    public java.lang.String getPatientName() {
      java.lang.Object ref = patientName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        patientName_ = s;
        return s;
      }
    }
    /**
     * <code>string patientName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getPatientNameBytes() {
      java.lang.Object ref = patientName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        patientName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DATEOFBIRTH_FIELD_NUMBER = 2;
    private volatile java.lang.Object dateOfBirth_;
    /**
     * <code>string dateOfBirth = 2;</code>
     */
    public java.lang.String getDateOfBirth() {
      java.lang.Object ref = dateOfBirth_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dateOfBirth_ = s;
        return s;
      }
    }
    /**
     * <code>string dateOfBirth = 2;</code>
     */
    public com.google.protobuf.ByteString
        getDateOfBirthBytes() {
      java.lang.Object ref = dateOfBirth_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dateOfBirth_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int HEIGHT_FIELD_NUMBER = 3;
    private volatile java.lang.Object height_;
    /**
     * <code>string height = 3;</code>
     */
    public java.lang.String getHeight() {
      java.lang.Object ref = height_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        height_ = s;
        return s;
      }
    }
    /**
     * <code>string height = 3;</code>
     */
    public com.google.protobuf.ByteString
        getHeightBytes() {
      java.lang.Object ref = height_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        height_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int EYECOLOR_FIELD_NUMBER = 4;
    private volatile java.lang.Object eyeColor_;
    /**
     * <code>string eyeColor = 4;</code>
     */
    public java.lang.String getEyeColor() {
      java.lang.Object ref = eyeColor_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        eyeColor_ = s;
        return s;
      }
    }
    /**
     * <code>string eyeColor = 4;</code>
     */
    public com.google.protobuf.ByteString
        getEyeColorBytes() {
      java.lang.Object ref = eyeColor_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        eyeColor_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int HEARTRATE_FIELD_NUMBER = 5;
    private volatile java.lang.Object heartRate_;
    /**
     * <code>string heartRate = 5;</code>
     */
    public java.lang.String getHeartRate() {
      java.lang.Object ref = heartRate_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        heartRate_ = s;
        return s;
      }
    }
    /**
     * <code>string heartRate = 5;</code>
     */
    public com.google.protobuf.ByteString
        getHeartRateBytes() {
      java.lang.Object ref = heartRate_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        heartRate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getPatientNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, patientName_);
      }
      if (!getDateOfBirthBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, dateOfBirth_);
      }
      if (!getHeightBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, height_);
      }
      if (!getEyeColorBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, eyeColor_);
      }
      if (!getHeartRateBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, heartRate_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getPatientNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, patientName_);
      }
      if (!getDateOfBirthBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, dateOfBirth_);
      }
      if (!getHeightBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, height_);
      }
      if (!getEyeColorBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, eyeColor_);
      }
      if (!getHeartRateBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, heartRate_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.ebs.broker.model.protobuf.Pub.Publication)) {
        return super.equals(obj);
      }
      com.ebs.broker.model.protobuf.Pub.Publication other = (com.ebs.broker.model.protobuf.Pub.Publication) obj;

      if (!getPatientName()
          .equals(other.getPatientName())) return false;
      if (!getDateOfBirth()
          .equals(other.getDateOfBirth())) return false;
      if (!getHeight()
          .equals(other.getHeight())) return false;
      if (!getEyeColor()
          .equals(other.getEyeColor())) return false;
      if (!getHeartRate()
          .equals(other.getHeartRate())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + PATIENTNAME_FIELD_NUMBER;
      hash = (53 * hash) + getPatientName().hashCode();
      hash = (37 * hash) + DATEOFBIRTH_FIELD_NUMBER;
      hash = (53 * hash) + getDateOfBirth().hashCode();
      hash = (37 * hash) + HEIGHT_FIELD_NUMBER;
      hash = (53 * hash) + getHeight().hashCode();
      hash = (37 * hash) + EYECOLOR_FIELD_NUMBER;
      hash = (53 * hash) + getEyeColor().hashCode();
      hash = (37 * hash) + HEARTRATE_FIELD_NUMBER;
      hash = (53 * hash) + getHeartRate().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.ebs.broker.model.protobuf.Pub.Publication parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ebs.broker.model.protobuf.Pub.Publication parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ebs.broker.model.protobuf.Pub.Publication parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ebs.broker.model.protobuf.Pub.Publication parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ebs.broker.model.protobuf.Pub.Publication parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ebs.broker.model.protobuf.Pub.Publication parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ebs.broker.model.protobuf.Pub.Publication parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.ebs.broker.model.protobuf.Pub.Publication parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.ebs.broker.model.protobuf.Pub.Publication parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.ebs.broker.model.protobuf.Pub.Publication parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.ebs.broker.model.protobuf.Pub.Publication parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.ebs.broker.model.protobuf.Pub.Publication parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.ebs.broker.model.protobuf.Pub.Publication prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.ebs.broker.model.protobuf.Publication}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.ebs.broker.model.protobuf.Publication)
        com.ebs.broker.model.protobuf.Pub.PublicationOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.ebs.broker.model.protobuf.Pub.internal_static_com_ebs_broker_model_protobuf_Publication_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.ebs.broker.model.protobuf.Pub.internal_static_com_ebs_broker_model_protobuf_Publication_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.ebs.broker.model.protobuf.Pub.Publication.class, com.ebs.broker.model.protobuf.Pub.Publication.Builder.class);
      }

      // Construct using com.ebs.broker.model.protobuf.Pub.Publication.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        patientName_ = "";

        dateOfBirth_ = "";

        height_ = "";

        eyeColor_ = "";

        heartRate_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.ebs.broker.model.protobuf.Pub.internal_static_com_ebs_broker_model_protobuf_Publication_descriptor;
      }

      @java.lang.Override
      public com.ebs.broker.model.protobuf.Pub.Publication getDefaultInstanceForType() {
        return com.ebs.broker.model.protobuf.Pub.Publication.getDefaultInstance();
      }

      @java.lang.Override
      public com.ebs.broker.model.protobuf.Pub.Publication build() {
        com.ebs.broker.model.protobuf.Pub.Publication result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.ebs.broker.model.protobuf.Pub.Publication buildPartial() {
        com.ebs.broker.model.protobuf.Pub.Publication result = new com.ebs.broker.model.protobuf.Pub.Publication(this);
        result.patientName_ = patientName_;
        result.dateOfBirth_ = dateOfBirth_;
        result.height_ = height_;
        result.eyeColor_ = eyeColor_;
        result.heartRate_ = heartRate_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.ebs.broker.model.protobuf.Pub.Publication) {
          return mergeFrom((com.ebs.broker.model.protobuf.Pub.Publication)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.ebs.broker.model.protobuf.Pub.Publication other) {
        if (other == com.ebs.broker.model.protobuf.Pub.Publication.getDefaultInstance()) return this;
        if (!other.getPatientName().isEmpty()) {
          patientName_ = other.patientName_;
          onChanged();
        }
        if (!other.getDateOfBirth().isEmpty()) {
          dateOfBirth_ = other.dateOfBirth_;
          onChanged();
        }
        if (!other.getHeight().isEmpty()) {
          height_ = other.height_;
          onChanged();
        }
        if (!other.getEyeColor().isEmpty()) {
          eyeColor_ = other.eyeColor_;
          onChanged();
        }
        if (!other.getHeartRate().isEmpty()) {
          heartRate_ = other.heartRate_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.ebs.broker.model.protobuf.Pub.Publication parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.ebs.broker.model.protobuf.Pub.Publication) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object patientName_ = "";
      /**
       * <code>string patientName = 1;</code>
       */
      public java.lang.String getPatientName() {
        java.lang.Object ref = patientName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          patientName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string patientName = 1;</code>
       */
      public com.google.protobuf.ByteString
          getPatientNameBytes() {
        java.lang.Object ref = patientName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          patientName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string patientName = 1;</code>
       */
      public Builder setPatientName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        patientName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string patientName = 1;</code>
       */
      public Builder clearPatientName() {
        
        patientName_ = getDefaultInstance().getPatientName();
        onChanged();
        return this;
      }
      /**
       * <code>string patientName = 1;</code>
       */
      public Builder setPatientNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        patientName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object dateOfBirth_ = "";
      /**
       * <code>string dateOfBirth = 2;</code>
       */
      public java.lang.String getDateOfBirth() {
        java.lang.Object ref = dateOfBirth_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          dateOfBirth_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string dateOfBirth = 2;</code>
       */
      public com.google.protobuf.ByteString
          getDateOfBirthBytes() {
        java.lang.Object ref = dateOfBirth_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          dateOfBirth_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string dateOfBirth = 2;</code>
       */
      public Builder setDateOfBirth(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        dateOfBirth_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string dateOfBirth = 2;</code>
       */
      public Builder clearDateOfBirth() {
        
        dateOfBirth_ = getDefaultInstance().getDateOfBirth();
        onChanged();
        return this;
      }
      /**
       * <code>string dateOfBirth = 2;</code>
       */
      public Builder setDateOfBirthBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        dateOfBirth_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object height_ = "";
      /**
       * <code>string height = 3;</code>
       */
      public java.lang.String getHeight() {
        java.lang.Object ref = height_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          height_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string height = 3;</code>
       */
      public com.google.protobuf.ByteString
          getHeightBytes() {
        java.lang.Object ref = height_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          height_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string height = 3;</code>
       */
      public Builder setHeight(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        height_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string height = 3;</code>
       */
      public Builder clearHeight() {
        
        height_ = getDefaultInstance().getHeight();
        onChanged();
        return this;
      }
      /**
       * <code>string height = 3;</code>
       */
      public Builder setHeightBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        height_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object eyeColor_ = "";
      /**
       * <code>string eyeColor = 4;</code>
       */
      public java.lang.String getEyeColor() {
        java.lang.Object ref = eyeColor_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          eyeColor_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string eyeColor = 4;</code>
       */
      public com.google.protobuf.ByteString
          getEyeColorBytes() {
        java.lang.Object ref = eyeColor_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          eyeColor_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string eyeColor = 4;</code>
       */
      public Builder setEyeColor(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        eyeColor_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string eyeColor = 4;</code>
       */
      public Builder clearEyeColor() {
        
        eyeColor_ = getDefaultInstance().getEyeColor();
        onChanged();
        return this;
      }
      /**
       * <code>string eyeColor = 4;</code>
       */
      public Builder setEyeColorBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        eyeColor_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object heartRate_ = "";
      /**
       * <code>string heartRate = 5;</code>
       */
      public java.lang.String getHeartRate() {
        java.lang.Object ref = heartRate_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          heartRate_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string heartRate = 5;</code>
       */
      public com.google.protobuf.ByteString
          getHeartRateBytes() {
        java.lang.Object ref = heartRate_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          heartRate_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string heartRate = 5;</code>
       */
      public Builder setHeartRate(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        heartRate_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string heartRate = 5;</code>
       */
      public Builder clearHeartRate() {
        
        heartRate_ = getDefaultInstance().getHeartRate();
        onChanged();
        return this;
      }
      /**
       * <code>string heartRate = 5;</code>
       */
      public Builder setHeartRateBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        heartRate_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.ebs.broker.model.protobuf.Publication)
    }

    // @@protoc_insertion_point(class_scope:com.ebs.broker.model.protobuf.Publication)
    private static final com.ebs.broker.model.protobuf.Pub.Publication DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.ebs.broker.model.protobuf.Pub.Publication();
    }

    public static com.ebs.broker.model.protobuf.Pub.Publication getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Publication>
        PARSER = new com.google.protobuf.AbstractParser<Publication>() {
      @java.lang.Override
      public Publication parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Publication(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Publication> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Publication> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.ebs.broker.model.protobuf.Pub.Publication getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ebs_broker_model_protobuf_Publication_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ebs_broker_model_protobuf_Publication_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\tpub.proto\022\035com.ebs.broker.model.protob" +
      "uf\"l\n\013Publication\022\023\n\013patientName\030\001 \001(\t\022\023" +
      "\n\013dateOfBirth\030\002 \001(\t\022\016\n\006height\030\003 \001(\t\022\020\n\010e" +
      "yeColor\030\004 \001(\t\022\021\n\theartRate\030\005 \001(\tb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_ebs_broker_model_protobuf_Publication_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_ebs_broker_model_protobuf_Publication_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ebs_broker_model_protobuf_Publication_descriptor,
        new java.lang.String[] { "PatientName", "DateOfBirth", "Height", "EyeColor", "HeartRate", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
