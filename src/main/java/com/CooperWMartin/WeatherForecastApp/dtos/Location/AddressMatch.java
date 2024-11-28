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

public class AddressMatch {
  private TigerLine tigerLine;
  private Coordinates coordinates;
  private AddressComponents addressComponents;
  private String matchedAddress;

  public AddressMatch() {
  }

  // Getters and Setters for AddressMatch
  public TigerLine getTigerLine() {
    return tigerLine;
  }

  public void setTigerLine(TigerLine tigerLine) {
    this.tigerLine = tigerLine;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public AddressComponents getAddressComponents() {
    return addressComponents;
  }

  public void setAddressComponents(AddressComponents addressComponents) {
    this.addressComponents = addressComponents;
  }

  public String getMatchedAddress() {
    return matchedAddress;
  }

  public void setMatchedAddress(String matchedAddress) {
    this.matchedAddress = matchedAddress;
  }
}
