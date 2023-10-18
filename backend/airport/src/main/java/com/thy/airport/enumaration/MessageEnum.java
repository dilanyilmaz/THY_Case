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
  SERIAL_CODE_WARNING(9, "Serial codes could not be retrieved from IWH"),
  PASSIVE_RECORD(10, "This Record is Passive"),
  NOT_STARTED_DAY(11, "There is No Started Day"),
  CAPACITY_PRIORITY(12,
      "This Record Can not Add Capacity Cause of Already Recored Assign/Capacity Task"),
  VEHICLE_TYPE(13, "This vehicle type is not used"),
  UNMATCHED_COUNTRY(14, "User Country And Selected Country Not Matched!"),
  LUB_CREATED_SUCCES(15, "ID LUB is created successfully!"),
  NOT_UPDATE_STATUS(16, "You Can Not Update While in This Status"),
  UNMATCHING_RECORDS(17, "Unmatching Records Exist - Task Ids :  "),
  NOT_UPDATEABLE(18, "This Record Can Not Update"),

  ADDED_TO_BLUE_POINT(19, "Your request is added to Blue Point list successfully!"),
  UPDATED_TO_BLUE_POINT(20, "Your request is updated to Blue Point list successfully!"),
  CANCELLED_TO_BLUE_POINT(21, "Your request is cancelled to Blue Point list successfully!"),
  CAUSE_TASK_NOT_COMPLETED(22, "Some Records Can Not Start:"),
  SUCCESS_PENDING_MESSAGE(23, "Your request is directed to relevant department successfully!"),
  NOT_REOPEN_MESSAGE(24, "Some Records Task Status Not Reopened :"),

  REOPEN_MESSAGE(25, "All Selected Tasks Reopened"),
  STARTED_SUCCESFULLY(26, "LUB Review started successfully"),
  BLUE_POINT_STARTED(27, "Blue Point Review started successfully"),
  YOU_CANNOT_START(28, "You cannot start this record because task(s) were started!"),
  TASK_COMPLETED_SUCCESSFULLY(29, " Task completed successfully"),
  SUCCESS(30, "Successfully"),
  REJECTED_SUCCESSFULLY(31, "Your request has been rejected successfully!”"),
  APPROVED_SUCCESSFULLY(32, "Your request has been approved successfully!"),

  CANCELLED_SUCCESSFULLY(33, "Your request has been cancelled successfully!"),
  CANNOT_BE_STARTED(34, "The Task(s) cannot be started!"),
  ORDER_CANCEL(35, " ID LUB/order is canceled!"),
  ABORT(36, " ID LUB/order is aborted!"),
  REORDER(37, " ID LUB/order is reordered!"),
  ORDER_ERROR(38, "Unexpected Error When Order Cancelation"),
  COMPLETED_LUB_ERROR(39, "This operation cannot be performed for completed Lubs."),
  LUB_CANCELED(40, "This Lub Canceled"),
  NO_RESPONSIBLE(41, "Question Can Not Save : No Responsible User For Related Task."),
  NOT_FOUND_BLUE_POINT(42, "There is No Related Blue Point"),
  COMPLETE_ABSCHLUSS(43, "Abschluss Meeting Completed"),
  INVALID_ID(44, "Invalid Related Id"),
  ALREADY_FINISHED(45, "This record has already been finished"),
  UNFINISHED_TASKS(46,"There are unfinished tasks for this record."),
  STATUS_UPDATED(47,"Status Updated Succesfully"),
  RELEASE_65(48,"Release 65 Process Successfully End"),
  RELEASE_70(49,"Release 70 Process Successfully End"),
  ROOT_CAUSE_NECESSARY(50,"Root Cause is Necessary!"),
  PRECAUTION_EXIST(51,"This Blue Point Has Already Precaution!"),
  ESCALATION(52,"This Blue Point Escalated"),
  ESCALATION_TO_IN_PROGRESS(53,"Blue Point Status Changed To In Progress"),
  ANOTHER_BUND(54,"Einbundelung - Aufbundelung Process Can Not Same Lub!"),
  NOT_AVAILABLE_FOR_BUND(55,"This Lub is not Available For Bunding"),
  MISSING_COMMENT(56,"It is mandatory to enter the comment field for the rejection process.");



  private Integer kod;
  private String message;

  MessageEnum(Integer kod, String message) {
    this.kod = kod;
    this.message = message;
  }
}
