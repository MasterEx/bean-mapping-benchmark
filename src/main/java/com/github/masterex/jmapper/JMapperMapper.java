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
package com.github.masterex.jmapper;

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
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JMapperMapper implements Mapper {

    public JMapperMapper() {
        try {
            mapper1 = new JMapper<>(TargetSimplePrimitiveObject.class, SourceSimplePrimitiveObject.class, Mapper.class.getResource("/jmapper.xml").toURI().toASCIIString());
            mapper2 = new JMapper<>(TargetSimpleListObject.class, SourceSimpleListObject.class, Mapper.class.getResource("/jmapper.xml").toURI().toASCIIString());
            mapper3 = new JMapper<>(TargetSimpleArrayObject.class, SourceSimpleArrayObject.class, Mapper.class.getResource("/jmapper.xml").toURI().toASCIIString());
            mapper4 = new JMapper<>(TargetComplexObject.class, SourceComplexObject.class, Mapper.class.getResource("/jmapper.xml").toURI().toASCIIString());
            mapper6 = new JMapper<>(SourceSimpleObject.class, SourceSimpleObject.class, Mapper.class.getResource("/jmapper.xml").toURI().toASCIIString());
            mapper7 = new JMapper<>(TargetComplexObject2.class, SourceComplexObject2.class, Mapper.class.getResource("/jmapper.xml").toURI().toASCIIString());
        } catch (URISyntaxException ex) {
            Logger.getLogger(JMapperMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    JMapperAPI api = new JMapperAPI()
            .add(JMapperAPI.mappedClass(TargetSimplePrimitiveObject.class))
            .add(JMapperAPI.mappedClass(TargetSimpleListObject.class))
            .add(JMapperAPI.mappedClass(TargetSimpleArrayObject.class))
            .add(JMapperAPI.mappedClass(TargetComplexObject.class));
    String p = Mapper.class.getResource("/jmapper.xml").getPath();
    private JMapper<TargetSimplePrimitiveObject, SourceSimplePrimitiveObject> mapper1;

    private JMapper<TargetSimpleListObject, SourceSimpleListObject> mapper2;

    private JMapper<TargetSimpleArrayObject, SourceSimpleArrayObject> mapper3;

    private JMapper<TargetComplexObject, SourceComplexObject> mapper4;

    private JMapper<SourceSimpleObject, SourceSimpleObject> mapper6;
    
    private JMapper<TargetComplexObject2, SourceComplexObject2> mapper7;

    @Override
    public TargetSimplePrimitiveObject convert(SourceSimplePrimitiveObject object) {
        return mapper1.getDestination(object);
    }

    @Override
    public TargetSimpleListObject convert(SourceSimpleListObject object) {
        return mapper2.getDestination(object);
    }

    @Override
    public TargetSimpleArrayObject convert(SourceSimpleArrayObject object) {
        return mapper3.getDestination(object);
    }

    @Override
    public TargetComplexObject convert(SourceComplexObject object) {
        return mapper4.getDestination(object);
    }

    @Override
    public SourceSimpleObject fromSimpleObjectToSimpleOject(SourceSimpleObject object) {
        return mapper6.getDestination(object);
    }

    @Override
    public TargetComplexObject2 convert(SourceComplexObject2 object) {
        return mapper7.getDestination(object);
    }

}
