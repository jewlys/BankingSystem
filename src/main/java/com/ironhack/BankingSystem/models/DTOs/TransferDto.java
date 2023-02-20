package com.ironhack.BankingSystem.models.DTOs;




import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferDto {

    private Integer senderAccountId;
    private String receiverName;
    private Integer receiverAccountId;
    private BigDecimal amount;

    public TransferDto(Integer senderAccountId, String receiverName, Integer receiverAccountId, BigDecimal amount) {
        this.senderAccountId = senderAccountId;
        this.receiverName = receiverName;
        this.receiverAccountId = receiverAccountId;
        this.amount = amount;
    }

    public Integer getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(Integer senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Integer getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(Integer receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}