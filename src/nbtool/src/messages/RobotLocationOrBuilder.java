// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RobotLocation.proto

package messages;

public interface RobotLocationOrBuilder extends
    // @@protoc_insertion_point(interface_extends:messages.RobotLocation)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional float x = 1;</code>
   */
  boolean hasX();
  /**
   * <code>optional float x = 1;</code>
   */
  float getX();

  /**
   * <code>optional float y = 2;</code>
   */
  boolean hasY();
  /**
   * <code>optional float y = 2;</code>
   */
  float getY();

  /**
   * <code>optional float h = 3;</code>
   */
  boolean hasH();
  /**
   * <code>optional float h = 3;</code>
   */
  float getH();

  /**
   * <code>optional int64 timestamp = 4;</code>
   */
  boolean hasTimestamp();
  /**
   * <code>optional int64 timestamp = 4;</code>
   */
  long getTimestamp();

  /**
   * <code>optional float uncert = 5;</code>
   */
  boolean hasUncert();
  /**
   * <code>optional float uncert = 5;</code>
   */
  float getUncert();

  /**
   * <code>optional bool lost = 6;</code>
   */
  boolean hasLost();
  /**
   * <code>optional bool lost = 6;</code>
   */
  boolean getLost();
}