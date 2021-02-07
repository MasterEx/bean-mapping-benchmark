/**
 * Copyright 2020 Periklis Ntanasis <pntanasis@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.github.masterex.models;

import java.math.BigInteger;
import java.util.Date;

public class SourceComplexObject {

    private SourceSimpleObject simpleObject;
    private SourceSimpleListObject listObject;
    private Date date;
    private BigInteger number;

    /**
     * @return the simpleObject
     */
    public SourceSimpleObject getSimpleObject() {
        return simpleObject;
    }

    /**
     * @param simpleObject the simpleObject to set
     */
    public void setSimpleObject(SourceSimpleObject simpleObject) {
        this.simpleObject = simpleObject;
    }

    /**
     * @return the listObject
     */
    public SourceSimpleListObject getListObject() {
        return listObject;
    }

    /**
     * @param listObject the listObject to set
     */
    public void setListObject(SourceSimpleListObject listObject) {
        this.listObject = listObject;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the number
     */
    public BigInteger getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(BigInteger number) {
        this.number = number;
    }

}
