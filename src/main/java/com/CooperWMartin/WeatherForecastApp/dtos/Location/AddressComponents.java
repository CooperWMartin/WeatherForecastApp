/**
 * MIT License
 *
 * Copyright (c) 2024 Scott Davis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
 
package com.CooperWMartin.WeatherForecastApp.dtos.Location;

public class AddressComponents {
  private String zip;
  private String streetName;
  private String preType;
  private String city;
  private String preDirection;
  private String suffixDirection;
  private String fromAddress;
  private String state;
  private String suffixType;
  private String toAddress;
  private String suffixQualifier;
  private String preQualifier;

  public AddressComponents() {
  }

  // Getters and Setters for AddressComponents
  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getPreType() {
    return preType;
  }

  public void setPreType(String preType) {
    this.preType = preType;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPreDirection() {
    return preDirection;
  }

  public void setPreDirection(String preDirection) {
    this.preDirection = preDirection;
  }

  public String getSuffixDirection() {
    return suffixDirection;
  }

  public void setSuffixDirection(String suffixDirection) {
    this.suffixDirection = suffixDirection;
  }

  public String getFromAddress() {
    return fromAddress;
  }

  public void setFromAddress(String fromAddress) {
    this.fromAddress = fromAddress;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getSuffixType() {
    return suffixType;
  }

  public void setSuffixType(String suffixType) {
    this.suffixType = suffixType;
  }

  public String getToAddress() {
    return toAddress;
  }

  public void setToAddress(String toAddress) {
    this.toAddress = toAddress;
  }

  public String getSuffixQualifier() {
    return suffixQualifier;
  }

  public void setSuffixQualifier(String suffixQualifier) {
    this.suffixQualifier = suffixQualifier;
  }

  public String getPreQualifier() {
    return preQualifier;
  }

  public void setPreQualifier(String preQualifier) {
    this.preQualifier = preQualifier;
  }
}