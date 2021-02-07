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

import com.codiform.moo.annotation.Access;
import com.codiform.moo.annotation.AccessMode;
import com.codiform.moo.annotation.Ignore;
import com.codiform.moo.annotation.Property;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Access(AccessMode.METHOD)
public class TargetComplexObject {

    private TargetSimplePrimitiveObject simpleObject;
    private TargetSimpleListObject listObject;
    private Date date;
    private BigInteger number;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.getSimpleObject());
        hash = 23 * hash + Objects.hashCode(this.getListObject());
        hash = 23 * hash + Objects.hashCode(this.getDate());
        hash = 23 * hash + Objects.hashCode(this.getNumber());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TargetComplexObject other = (TargetComplexObject) obj;
        if (!Objects.equals(this.simpleObject, other.simpleObject)) {
            return false;
        }
        if (!Objects.equals(this.listObject, other.listObject)) {
            return false;
        }
        int t = this.date.compareTo(other.date);
        long t1 = this.date.getTime();
        long t2 = other.date.getTime();
        if (this.date.compareTo(other.date) != 0) {
            return false;
        }
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        return true;
    }

    /**
     * @return the simpleObject
     */
    public TargetSimplePrimitiveObject getSimpleObject() {
        return simpleObject;
    }

    /**
     * @param simpleObject the simpleObject to set
     */
    @Ignore
    @Property(source = "simpleObject")
    public void setSimpleObject(TargetSimplePrimitiveObject simpleObject) {
        this.simpleObject = simpleObject;
    }

    /**
     * @return the listObject
     */
    public TargetSimpleListObject getListObject() {
        return listObject;
    }

    /**
     * @param listObject the listObject to set
     */
    @Ignore
    @Property(source = "listObject")
    public void setListObject(TargetSimpleListObject listObject) {
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
