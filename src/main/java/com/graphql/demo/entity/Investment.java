package com.graphql.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Investment {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private Long investmentId;
   private Long fundId;
   private String fundName;
   private String email;
   private String closeDate;
   private String classType;
   private String clientAccountNumber;
   private String clientAccountName;
   private String bankName;
   private String bankAba;
   private String accountNum;
   private String accountName;
   private String swiftCode;
   private String ffc;
   private String bankReference;
   private Long taxId;
   private Integer amount;
   private String managementFee;
   private String ir;
   private String compliance;
   private String investorName;
   private Long investorId;
   private String investorDob;
   private String addressLine1;
   private String addressLine2;
   private String city;
   private String state;
   private String zip;
   private String country;
}
