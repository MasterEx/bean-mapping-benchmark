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
import com.codiform.moo.annotation.Property;
import java.util.Objects;

@Access(AccessMode.METHOD)
public class TargetSimplePrimitiveObject {

    private int field1;
    private boolean field2;
    private String field3;
    private char field4;
    private double field5;

    /**
     * @return the field1
     */
    public int getField1() {
        return field1;
    }

    /**
     * @param field1 the field1 to set
     */
    public void setField1(int field1) {
        this.field1 = field1;
    }

    /**
     * @return the field2
     */
    public boolean isField2() {
        return field2;
    }

    /**
     * @param field2 the field2 to set
     */
    public void setField2(boolean field2) {
        this.field2 = field2;
    }

    /**
     * @return the field3
     */
    public String getField3() {
        return field3;
    }

    /**
     * @param field3 the field3 to set
     */
    public void setField3(String field3) {
        this.field3 = field3;
    }

    /**
     * @return the field4
     */
    public char getField4() {
        return field4;
    }

    /**
     * @param field4 the field4 to set
     */
    public void setField4(char field4) {
        this.field4 = field4;
    }

    /**
     * Workaround for Moo Mapper to work (SimplePrimitiveObjectMappingTest)
     *
     * @param field4
     */
    @Property(source = "field4")
    public void setField4(Character field4) {
        this.field4 = field4;
    }

    /**
     * @return the field5
     */
    public double getField5() {
        return field5;
    }

    /**
     * @param field5 the field5 to set
     */
    public void setField5(double field5) {
        this.field5 = field5;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.field1;
        hash = 97 * hash + (this.field2 ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.field3);
        hash = 97 * hash + this.field4;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.field5) ^ (Double.doubleToLongBits(this.field5) >>> 32));
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
        final TargetSimplePrimitiveObject other = (TargetSimplePrimitiveObject) obj;
        if (this.field1 != other.field1) {
            return false;
        }
        if (this.field2 != other.field2) {
            return false;
        }
        if (this.field4 != other.field4) {
            return false;
        }
        if (Double.doubleToLongBits(this.field5) != Double.doubleToLongBits(other.field5)) {
            return false;
        }
        if (!Objects.equals(this.field3, other.field3)) {
            return false;
        }
        return true;
    }

}
