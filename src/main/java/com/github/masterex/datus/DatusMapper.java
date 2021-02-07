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
package com.github.masterex.datus;

import com.github.masterex.Mapper;
import com.github.masterex.models.SourceComplexObject;
import com.github.masterex.models.SourceComplexObject2;
import com.github.masterex.models.SourceIntegerWrapper;
import com.github.masterex.models.SourceSimpleArrayObject;
import com.github.masterex.models.SourceSimpleListObject;
import com.github.masterex.models.SourceSimpleObject;
import com.github.masterex.models.SourceSimplePrimitiveObject;
import com.github.masterex.models.TargetComplexObject;
import com.github.masterex.models.TargetComplexObject2;
import com.github.masterex.models.TargetIntegerWrapper;
import com.github.masterex.models.TargetSimpleArrayObject;
import com.github.masterex.models.TargetSimpleListObject;
import com.github.masterex.models.TargetSimplePrimitiveObject;
import com.github.roookeee.datus.api.Datus;

public class DatusMapper implements Mapper {

    private final DatusMapper self;

    public DatusMapper() {
        self = this;
    }

    private final com.github.roookeee.datus.api.Mapper<SourceSimplePrimitiveObject, TargetSimplePrimitiveObject> mapper1
            = Datus.forTypes(SourceSimplePrimitiveObject.class, TargetSimplePrimitiveObject.class)
                    .mutable(TargetSimplePrimitiveObject::new)
                    .from(SourceSimplePrimitiveObject::getField1).into(TargetSimplePrimitiveObject::setField1)
                    .from(SourceSimplePrimitiveObject::isField2).into(TargetSimplePrimitiveObject::setField2)
                    .from(SourceSimplePrimitiveObject::getField3).into(TargetSimplePrimitiveObject::setField3)
                    .from(SourceSimplePrimitiveObject::getField4).into(TargetSimplePrimitiveObject::setField4)
                    .from(SourceSimplePrimitiveObject::getField5).into(TargetSimplePrimitiveObject::setField5)
                    .build();

    private final com.github.roookeee.datus.api.Mapper<SourceSimpleObject, TargetSimplePrimitiveObject> mapper2
            = Datus.forTypes(SourceSimpleObject.class, TargetSimplePrimitiveObject.class)
                    .mutable(TargetSimplePrimitiveObject::new)
                    .from(SourceSimpleObject::getField1).into(TargetSimplePrimitiveObject::setField1)
                    .from(SourceSimpleObject::isField2).into(TargetSimplePrimitiveObject::setField2)
                    .from(SourceSimpleObject::getField3).into(TargetSimplePrimitiveObject::setField3)
                    .from(SourceSimpleObject::getField4).into(TargetSimplePrimitiveObject::setField4)
                    .from(SourceSimpleObject::getField5).into(TargetSimplePrimitiveObject::setField5)
                    .build();

    private final com.github.roookeee.datus.api.Mapper<SourceSimpleObject, SourceSimpleObject> mapper3
            = Datus.forTypes(SourceSimpleObject.class, SourceSimpleObject.class)
                    .mutable(SourceSimpleObject::new)
                    .from(SourceSimpleObject::getField1).into(SourceSimpleObject::setField1)
                    .from(SourceSimpleObject::isField2).into(SourceSimpleObject::setField2)
                    .from(SourceSimpleObject::getField3).into(SourceSimpleObject::setField3)
                    .from(SourceSimpleObject::getField4).into(SourceSimpleObject::setField4)
                    .from(SourceSimpleObject::getField5).into(SourceSimpleObject::setField5)
                    .build();

    private final com.github.roookeee.datus.api.Mapper<SourceSimpleListObject, TargetSimpleListObject> mapper4
            = Datus.forTypes(SourceSimpleListObject.class, TargetSimpleListObject.class)
                    .mutable(TargetSimpleListObject::new)
                    .from(SourceSimpleListObject::getList1).into(TargetSimpleListObject::setList1)
                    .from(SourceSimpleListObject::getList2).into(TargetSimpleListObject::setList2)
                    .from(SourceSimpleListObject::getList3).into(TargetSimpleListObject::setList3)
                    .from(SourceSimpleListObject::getList4).into(TargetSimpleListObject::setList4)
                    .from(SourceSimpleListObject::getList5).into(TargetSimpleListObject::setList5)
                    .build();

    private final com.github.roookeee.datus.api.Mapper<SourceSimpleArrayObject, TargetSimpleArrayObject> mapper5
            = Datus.forTypes(SourceSimpleArrayObject.class, TargetSimpleArrayObject.class)
                    .mutable(TargetSimpleArrayObject::new)
                    .from(SourceSimpleArrayObject::getArray1).into(TargetSimpleArrayObject::setArray1)
                    .from(SourceSimpleArrayObject::getArray2).into(TargetSimpleArrayObject::setArray2)
                    .from(SourceSimpleArrayObject::getArray3).into(TargetSimpleArrayObject::setArray3)
                    .from(SourceSimpleArrayObject::getArray4).into(TargetSimpleArrayObject::setArray4)
                    .from(SourceSimpleArrayObject::getArray5).into(TargetSimpleArrayObject::setArray5)
                    .build();

    private final com.github.roookeee.datus.api.Mapper<SourceComplexObject, TargetComplexObject> mapper6
            = Datus.forTypes(SourceComplexObject.class, TargetComplexObject.class)
                    .mutable(TargetComplexObject::new)
                    .from(SourceComplexObject::getDate).into(TargetComplexObject::setDate)
                    .from(SourceComplexObject::getNumber).into(TargetComplexObject::setNumber)
                    .from(SourceComplexObject::getListObject)
                    .map(mapper4::convert)
                    .into(TargetComplexObject::setListObject)
                    .from(SourceComplexObject::getSimpleObject)
                    .map(mapper2::convert)
                    .into(TargetComplexObject::setSimpleObject)
                    .build();
    
    private final com.github.roookeee.datus.api.Mapper<SourceIntegerWrapper, TargetIntegerWrapper> sourceIntegerMapper
            = Datus.forTypes(SourceIntegerWrapper.class, TargetIntegerWrapper.class)
                    .mutable(TargetIntegerWrapper::new)
                    .from(SourceIntegerWrapper::getO).into(TargetIntegerWrapper::setO)
                    .build();
    
    private final com.github.roookeee.datus.api.Mapper<SourceComplexObject2, TargetComplexObject2> mapper7
            = Datus.forTypes(SourceComplexObject2.class, TargetComplexObject2.class)
                    .mutable(TargetComplexObject2::new)
                    .from(SourceComplexObject2::getList1)
                    .map(sourceIntegerMapper::convert)
                    .into(TargetComplexObject2::setList1)
                    .build();

    @Override
    public TargetSimplePrimitiveObject convert(SourceSimplePrimitiveObject object) {
        return mapper1.convert(object);
    }

    @Override
    public SourceSimpleObject fromSimpleObjectToSimpleOject(SourceSimpleObject object) {
        return mapper3.convert(object);
    }

    @Override
    public TargetSimpleListObject convert(SourceSimpleListObject object) {
        return mapper4.convert(object);
    }

    @Override
    public TargetSimpleArrayObject convert(SourceSimpleArrayObject object) {
        return mapper5.convert(object);
    }

    @Override
    public TargetComplexObject convert(SourceComplexObject object) {
        return mapper6.convert(object);
    }

    @Override
    public TargetComplexObject2 convert(SourceComplexObject2 object) {
        return mapper7.convert(object);
    }

}
