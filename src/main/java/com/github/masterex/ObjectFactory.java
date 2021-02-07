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
package com.github.masterex;

import com.github.masterex.models.SourceComplexObject;
import com.github.masterex.models.SourceComplexObject2;
import com.github.masterex.models.SourceIntegerWrapper;
import com.github.masterex.models.SourceSimpleArrayObject;
import com.github.masterex.models.SourceSimpleListObject;
import com.github.masterex.models.SourceSimpleObject;
import com.github.masterex.models.SourceSimplePrimitiveObject;
import com.github.masterex.models.TargetComplexObject;
import com.github.masterex.models.TargetSimpleArrayObject;
import com.github.masterex.models.TargetSimpleListObject;
import com.github.masterex.models.TargetSimplePrimitiveObject;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author master
 */
public class ObjectFactory {

    private static final Date DATE = new Date();

    public static SourceSimplePrimitiveObject getSourceSimplePrimitiveObject() {
        SourceSimplePrimitiveObject source = new SourceSimplePrimitiveObject();
        source.setField1(15);
        source.setField2(true);
        source.setField3("This is a test");
        source.setField4('t');
        source.setField5(12.432);
        return source;
    }

    public static SourceSimpleObject getSourceSimpleObject() {
        SourceSimpleObject source = new SourceSimpleObject();
        source.setField1(15);
        source.setField2(true);
        source.setField3("This is a test");
        source.setField4('t');
        source.setField5(12.432);
        return source;
    }

    public static TargetSimplePrimitiveObject getTargetSimpleObject() {
        TargetSimplePrimitiveObject source = new TargetSimplePrimitiveObject();
        source.setField1(15);
        source.setField2(true);
        source.setField3("This is a test");
        source.setField4('t');
        source.setField5(12.432);
        return source;
    }

    public static SourceSimpleListObject getSourceSimpleListObject() {
        SourceSimpleListObject sourceList = new SourceSimpleListObject();
        for (int i = 0; i < 1000; i++) {
            sourceList.getList1().add(i);
            sourceList.getList2().add(i % 1 == 0);
            sourceList.getList3().add("STRING " + i);
            sourceList.getList4().add((char) i);
            sourceList.getList5().add(i + 0.0005313);
        }
        return sourceList;
    }

    public static TargetSimpleListObject getTargetSimpleListObject() {
        TargetSimpleListObject sourceList = new TargetSimpleListObject();
        for (int i = 0; i < 1000; i++) {
            sourceList.getList1().add(i);
            sourceList.getList2().add(i % 1 == 0);
            sourceList.getList3().add("STRING " + i);
            sourceList.getList4().add((char) i);
            sourceList.getList5().add(i + 0.0005313);
        }
        return sourceList;
    }

    public static SourceSimpleArrayObject getSourceSimpleArrayObject() {
        SourceSimpleArrayObject sourceArray = new SourceSimpleArrayObject();
        for (int i = 0; i < 1000; i++) {
            sourceArray.getArray1()[i] = i;
            sourceArray.getArray2()[i] = i % 1 == 0;
            sourceArray.getArray3()[i] = "STRING " + i;
            sourceArray.getArray4()[i] = (char) i;
            sourceArray.getArray5()[i] = i + 0.0005313;
        }
        return sourceArray;
    }

    public static TargetSimpleArrayObject getTargetSimpleArrayObject() {
        TargetSimpleArrayObject sourceArray = new TargetSimpleArrayObject();
        for (int i = 0; i < 1000; i++) {
            sourceArray.getArray1()[i] = i;
            sourceArray.getArray2()[i] = i % 1 == 0;
            sourceArray.getArray3()[i] = "STRING " + i;
            sourceArray.getArray4()[i] = (char) i;
            sourceArray.getArray5()[i] = i + 0.0005313;
        }
        return sourceArray;
    }

    public static SourceComplexObject getSourceComplexObject() {
        SourceComplexObject sourceComplexObject = new SourceComplexObject();
        sourceComplexObject.setDate(new Date(DATE.getTime()));
        sourceComplexObject.setNumber(BigInteger.TEN);
        sourceComplexObject.setSimpleObject(getSourceSimpleObject());
        sourceComplexObject.setListObject(getSourceSimpleListObject());
        return sourceComplexObject;
    }

    public static TargetComplexObject getTargetComplexObject() {
        TargetComplexObject sourceComplexObject = new TargetComplexObject();
        sourceComplexObject.setDate(new Date(DATE.getTime()));
        sourceComplexObject.setNumber(BigInteger.TEN);
        sourceComplexObject.setSimpleObject(getTargetSimpleObject());
        sourceComplexObject.setListObject(getTargetSimpleListObject());
        return sourceComplexObject;
    }
    
    public static SourceComplexObject2 getSourceComplexObject2() {
        SourceComplexObject2 source = new SourceComplexObject2();
        
        for (int i = 0; i < 1000; i++) {
            source.getList1().add(new SourceIntegerWrapper(i));
        }
        return source;
    }

}
