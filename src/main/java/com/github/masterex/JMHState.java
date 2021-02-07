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

import com.github.masterex.beancp.BeanCPMapper;
import com.github.masterex.beanutils.BeanUtilsMapper;
import com.github.masterex.bull.BullMapper;
import com.github.masterex.datus.DatusMapper;
import com.github.masterex.dozer.DozerMapper;
import com.github.masterex.jmapper.JMapperMapper;
import com.github.masterex.mapstruct.MapStructMapper;
import com.github.masterex.mapstruct.MapStructShallowCopyMapper;
import com.github.masterex.modelmapper.ModelMapperMapper;
import com.github.masterex.models.SourceComplexObject;
import com.github.masterex.models.SourceSimpleArrayObject;
import com.github.masterex.models.SourceSimpleListObject;
import com.github.masterex.models.SourceSimplePrimitiveObject;
import com.github.masterex.moo.MooMapper;
import com.github.masterex.models.SourceSimpleObject;
import com.github.masterex.nomin.NominMapper;
import com.github.masterex.orika.OrikaMapper;
import com.github.masterex.remap.RemapMapper;
import com.github.masterex.selma.SelmaMapper;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class JMHState {

    public SourceSimplePrimitiveObject source;
    public SourceSimpleListObject sourceList;
    public SourceSimpleArrayObject sourceArray;
    public SourceComplexObject sourceComplex;
    public Mapper dozerMapper = new DozerMapper();
    public Mapper jMapperMapper = new JMapperMapper();
    public Mapper mapStructMapper = new MapStructMapper();
    public Mapper mapStructShallowCopyMapper = new MapStructShallowCopyMapper();
    public Mapper modelMapperMapper = new ModelMapperMapper();
    public Mapper orikaMapper = new OrikaMapper();
    public Mapper selmaMapper = new SelmaMapper();
    public Mapper beanCpMapper = new BeanCPMapper();
    public Mapper beanUtilsMapper = new BeanUtilsMapper();
    public Mapper nominMapper = new NominMapper();
    public Mapper mooMapper = new MooMapper();
    public Mapper bullMapper = new BullMapper();
    public Mapper datusMapper = new DatusMapper();
    public Mapper remapMapper = new RemapMapper();
    public SourceSimpleObject mooSourceObject = new SourceSimpleObject();

    @Setup(Level.Trial)
    public void doSetup() {
        source = ObjectFactory.getSourceSimplePrimitiveObject();
        sourceList = ObjectFactory.getSourceSimpleListObject();
        sourceArray = ObjectFactory.getSourceSimpleArrayObject();
        sourceComplex = ObjectFactory.getSourceComplexObject();
        mooSourceObject.setField1(15);
        mooSourceObject.setField2(true);
        mooSourceObject.setField3("This is a test");
        mooSourceObject.setField4('t');
        mooSourceObject.setField5(12.432);
    }

}
