package com.thy.airport.enumaration;

import lombok.Getter;

@Getter
public enum MessageEnum {

  NOT_FOUND(1, "The record is not found!"),
  NOT_AUTH(2, "You are not authorized for this process!"),
  UNEXPECTED_ERROR(3, "UNEXPECTED ERROR!"),
  UPDATE_SUCCESS(4, "Record is updated successfully."),
  SAVE_SUCCESS(5, "Record is saved successfully."),
  DELETE_SUCCESS(6, "Record is deleted successfully."),
  RECORD_EXISTS(7, "Record already exists"),
  EMPTY_LIST(8, "List is Empty"),
  NOT_UPDATEABLE(18, "This Record Can Not Update"),
  SUCCESS(30, "Successfully");


  private Integer kod;
  private String message;

  MessageEnum(Integer kod, String message) {
    this.kod = kod;
    this.message = message;
  }
}
