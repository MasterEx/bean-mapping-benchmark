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
package com.github.masterex.remap;

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
import com.remondis.remap.Mapping;

public class RemapMapper implements Mapper {

    private final RemapMapper self;

    public RemapMapper() {
        self = this;
    }

    com.remondis.remap.Mapper<SourceSimplePrimitiveObject, TargetSimplePrimitiveObject> mapper1 = Mapping
            .from(SourceSimplePrimitiveObject.class)
            .to(TargetSimplePrimitiveObject.class)
            .mapper();

    com.remondis.remap.Mapper<SourceSimpleObject, TargetSimplePrimitiveObject> mapper2 = Mapping
            .from(SourceSimpleObject.class)
            .to(TargetSimplePrimitiveObject.class)
            .mapper();

    com.remondis.remap.Mapper<SourceSimpleObject, SourceSimpleObject> mapper3 = Mapping
            .from(SourceSimpleObject.class)
            .to(SourceSimpleObject.class)
            .mapper();

    com.remondis.remap.Mapper<SourceSimpleListObject, TargetSimpleListObject> mapper4 = Mapping
            .from(SourceSimpleListObject.class)
            .to(TargetSimpleListObject.class)
            .mapper();

    com.remondis.remap.Mapper<SourceSimpleArrayObject, TargetSimpleArrayObject> mapper5 = Mapping
            .from(SourceSimpleArrayObject.class)
            .to(TargetSimpleArrayObject.class)
            .mapper();

    com.remondis.remap.Mapper<SourceComplexObject, TargetComplexObject> mapper6 = Mapping
            .from(SourceComplexObject.class)
            .to(TargetComplexObject.class)
            .replace(SourceComplexObject::getListObject, TargetComplexObject::getListObject)
            .withSkipWhenNull(mapper4::map)
            .replace(SourceComplexObject::getSimpleObject, TargetComplexObject::getSimpleObject)
            .withSkipWhenNull(mapper2::map)
            .mapper();

    com.remondis.remap.Mapper<SourceIntegerWrapper, TargetIntegerWrapper> mapperSourceIntegerWrapper = Mapping
            .from(SourceIntegerWrapper.class)
            .to(TargetIntegerWrapper.class)
            .mapper();

    com.remondis.remap.Mapper<SourceComplexObject2, TargetComplexObject2> mapper7 = Mapping
            .from(SourceComplexObject2.class)
            .to(TargetComplexObject2.class)
            .useMapper(mapperSourceIntegerWrapper)
            .mapper();

    @Override
    public TargetSimplePrimitiveObject convert(SourceSimplePrimitiveObject object) {
        return mapper1.map(object);
    }

    @Override
    public SourceSimpleObject fromSimpleObjectToSimpleOject(SourceSimpleObject object) {
        return mapper3.map(object);
    }

    @Override
    public TargetSimpleListObject convert(SourceSimpleListObject object) {
        return mapper4.map(object);
    }

    @Override
    public TargetSimpleArrayObject convert(SourceSimpleArrayObject object) {
        return mapper5.map(object);
    }

    @Override
    public TargetComplexObject convert(SourceComplexObject object) {
        return mapper6.map(object);
    }

    @Override
    public TargetComplexObject2 convert(SourceComplexObject2 object) {
        return mapper7.map(object);
    }

}
