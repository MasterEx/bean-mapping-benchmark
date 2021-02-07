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
package com.github.masterex.selma;

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
import fr.xebia.extras.selma.Selma;

public class SelmaMapper implements Mapper {

    SMapper mapper = Selma.builder(SMapper.class).build();

    @Override
    public TargetSimplePrimitiveObject convert(SourceSimplePrimitiveObject object) {
        return mapper.map(object);
    }

    @Override
    public TargetSimpleListObject convert(SourceSimpleListObject object) {
        return mapper.map(object);
    }

    @Override
    public TargetSimpleArrayObject convert(SourceSimpleArrayObject object) {
        return mapper.map(object);
    }

    @Override
    public TargetComplexObject convert(SourceComplexObject object) {
        return mapper.map(object);
    }

    @Override
    public SourceSimpleObject fromSimpleObjectToSimpleOject(SourceSimpleObject object) {
        return mapper.map2(object);
    }

    @Override
    public TargetComplexObject2 convert(SourceComplexObject2 object) {
        return mapper.map(object);
    }

}
