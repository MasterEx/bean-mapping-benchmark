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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TargetSimpleListObject {

    private List<Integer> list1 = new ArrayList<>();
    private List<Boolean> list2 = new ArrayList<>();
    private List<String> list3 = new ArrayList<>();
    private List<Character> list4 = new ArrayList<>();
    private List<Double> list5 = new ArrayList<>();

    /**
     * @return the list1
     */
    public List<Integer> getList1() {
        return list1;
    }

    /**
     * @param list1 the list1 to set
     */
    public void setList1(List<Integer> list1) {
        this.list1 = list1;
    }

    /**
     * @return the list2
     */
    public List<Boolean> getList2() {
        return list2;
    }

    /**
     * @param list2 the list2 to set
     */
    public void setList2(List<Boolean> list2) {
        this.list2 = list2;
    }

    /**
     * @return the list3
     */
    public List<String> getList3() {
        return list3;
    }

    /**
     * @param list3 the list3 to set
     */
    public void setList3(List<String> list3) {
        this.list3 = list3;
    }

    /**
     * @return the list4
     */
    public List<Character> getList4() {
        return list4;
    }

    /**
     * @param list4 the list4 to set
     */
    public void setList4(List<Character> list4) {
        this.list4 = list4;
    }

    /**
     * @return the list5
     */
    public List<Double> getList5() {
        return list5;
    }

    /**
     * @param list5 the list5 to set
     */
    public void setList5(List<Double> list5) {
        this.list5 = list5;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.list1);
        hash = 29 * hash + Objects.hashCode(this.list2);
        hash = 29 * hash + Objects.hashCode(this.list3);
        hash = 29 * hash + Objects.hashCode(this.list4);
        hash = 29 * hash + Objects.hashCode(this.list5);
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
        final TargetSimpleListObject other = (TargetSimpleListObject) obj;
        if (!Objects.equals(this.list1, other.list1)) {
            return false;
        }
        if (!Objects.equals(this.list2, other.list2)) {
            return false;
        }
        if (!Objects.equals(this.list3, other.list3)) {
            return false;
        }
        if (!Objects.equals(this.list4, other.list4)) {
            return false;
        }
        if (!Objects.equals(this.list5, other.list5)) {
            return false;
        }
        return true;
    }

}
