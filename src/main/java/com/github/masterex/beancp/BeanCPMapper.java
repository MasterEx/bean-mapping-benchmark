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
package com.github.masterex.beancp;

import com.github.erchu.beancp.MapperBuilder;
import com.github.erchu.beancp.commons.NameBasedMapConvention;
import com.github.masterex.Mapper;
import com.github.masterex.models.SourceComplexObject;
import com.github.masterex.models.SourceComplexObject2;
import com.github.masterex.models.SourceSimpleArrayObject;
import com.github.masterex.models.SourceSimpleListObject;
import com.github.masterex.models.SourceSimpleObject;
import com.github.masterex.models.SourceSimplePrimitiveObject;
import com.github.masterex.models.TargetComplexObject;
import com.github.masterex.models.TargetComplexObject2;
import com.github.masterex.models.TargetSimpleArrayObject;
import com.github.masterex.models.TargetSimpleListObject;
import com.github.masterex.models.TargetSimplePrimitiveObject;

public class BeanCPMapper implements Mapper {

    com.github.erchu.beancp.Mapper mapper;

    public BeanCPMapper() {
        mapper = new MapperBuilder()
                .addMap(SourceSimplePrimitiveObject.class, TargetSimplePrimitiveObject.class,
                        (conf, source, destination) -> conf
                                .useConvention(NameBasedMapConvention.get()))
                .addMap(SourceSimpleObject.class, TargetSimplePrimitiveObject.class,
                        (conf, source, destination) -> conf
                                .useConvention(NameBasedMapConvention.get())
                                .bind(source::getField1, destination::setField1)
                                .bind(source::getField2, destination::setField2)
                                .bind(source::getField3, destination::setField3)
                                .bind(source::getField4, destination::setField4)
                                .bind(source::getField5, destination::setField5))
                .addMap(SourceSimpleListObject.class, TargetSimpleListObject.class,
                        (conf, source, destination) -> conf
                                .useConvention(NameBasedMapConvention.get()))
                .addMap(SourceComplexObject.class, TargetComplexObject.class,
                        (conf, source, destination) -> conf
                                .useConvention(NameBasedMapConvention.get())
                                .mapInner(source::getSimpleObject, destination::setSimpleObject, TargetSimplePrimitiveObject.class))
                .addMap(SourceSimpleArrayObject.class, TargetSimpleArrayObject.class,
                        (conf, source, destination) -> conf
                                .useConvention(NameBasedMapConvention.get()))
                .addMap(SourceComplexObject2.class, TargetComplexObject2.class,
                        (conf, source, destination) -> conf
                                .useConvention(NameBasedMapConvention.get()))
                .addMap(SourceSimpleObject.class, SourceSimpleObject.class,
                        (conf, source, destination) -> conf
                                .useConvention(NameBasedMapConvention.get())
                                // for some reason this wasn't mapped with the NameBaseMapConvention
                                .bind(source::getField2, destination::setField2))
                .buildMapper();
    }

    @Override
    public TargetSimplePrimitiveObject convert(SourceSimplePrimitiveObject object) {
        return mapper.map(object, TargetSimplePrimitiveObject.class);
    }

    @Override
    public TargetSimpleListObject convert(SourceSimpleListObject object) {
        return mapper.map(object, TargetSimpleListObject.class);
    }

    @Override
    public TargetSimpleArrayObject convert(SourceSimpleArrayObject object) {
        return mapper.map(object, TargetSimpleArrayObject.class);
    }

    @Override
    public TargetComplexObject convert(SourceComplexObject object) {
        return mapper.map(object, TargetComplexObject.class);
    }

    @Override
    public SourceSimpleObject fromSimpleObjectToSimpleOject(SourceSimpleObject object) {
        return mapper.map(object, SourceSimpleObject.class);
    }

    @Override
    public TargetComplexObject2 convert(SourceComplexObject2 object) {
        return mapper.map(object, TargetComplexObject2.class);
    }

}
