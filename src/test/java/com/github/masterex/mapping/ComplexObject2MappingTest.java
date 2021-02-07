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
package com.github.masterex.mapping;

import com.github.masterex.Mapper;
import com.github.masterex.ObjectFactory;
import com.github.masterex.bull.BullMapper;
import com.github.masterex.datus.DatusMapper;
import com.github.masterex.dozer.DozerMapper;
import com.github.masterex.jmapper.JMapperMapper;
import com.github.masterex.mapstruct.MapStructMapper;
import com.github.masterex.modelmapper.ModelMapperMapper;
import com.github.masterex.models.SourceComplexObject2;
import com.github.masterex.models.TargetComplexObject2;
import com.github.masterex.nomin.NominMapper;
import com.github.masterex.orika.OrikaMapper;
import com.github.masterex.remap.RemapMapper;
import com.github.masterex.selma.SelmaMapper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComplexObject2MappingTest {

    static SourceComplexObject2 source;
    static TargetComplexObject2 target;

    @BeforeClass
    public static void init() {
        source = ObjectFactory.getSourceComplexObject2();
    }

//    @Test
//    public void beanCpTest() {
//        Mapper mapper = new BeanCPMapper();
//        testMap(mapper);
//    }
//
//    @Test
//    public void beanUtilsTest() {
//        Mapper mapper = new BeanUtilsMapper();
//        testMap(mapper);
//    }

    @Test
    public void dozerTest() {
        Mapper mapper = new DozerMapper();
        testMap(mapper);
    }

    @Test
    public void jMapperTest() {
        Mapper mapper = new JMapperMapper();
        testMap(mapper);
    }

    @Test
    public void mapStructTest() {
        Mapper mapper = new MapStructMapper();
        testMap(mapper);
    }

    @Test
    public void modelMapperTest() {
        Mapper mapper = new ModelMapperMapper();
        testMap(mapper);
    }

//    @Test
//    public void mooTest() {
//        Mapper mapper = new MooMapper();
//        testMap(mapper);
//    }

    @Test
    public void nominTest() {
        Mapper mapper = new NominMapper();
        testMap(mapper);
    }

    @Test
    public void orikaTest() {
        Mapper mapper = new OrikaMapper();
        testMap(mapper);
    }

    @Test
    public void selmaTest() {
        Mapper mapper = new SelmaMapper();
        testMap(mapper);
    }

    @Test
    public void bullTest() {
        Mapper mapper = new BullMapper();
        testMap(mapper);
    }

    @Test
    public void datusTest() {
        Mapper mapper = new DatusMapper();
        testMap(mapper);
    }

    @Test
    public void remapTest() {
        Mapper mapper = new RemapMapper();
        testMap(mapper);
    }

    private void testMap(Mapper mapper) {
        TargetComplexObject2 mappingTarget = mapper.convert(source);
        assertNotSame(source.getList1(), mappingTarget.getList1());
        for (int i=0; i<1000; i++) {
            assertNotSame(source.getList1().get(i), mappingTarget.getList1().get(i));
            assertEquals(source.getList1().get(i).getO(), mappingTarget.getList1().get(i).getO());
            assertTrue(source.getList1().get(i).getO() == mappingTarget.getList1().get(i).getO());
        }
    }
    
}
