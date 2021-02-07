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
import com.github.masterex.beancp.BeanCPMapper;
import com.github.masterex.beanutils.BeanUtilsMapper;
import com.github.masterex.bull.BullMapper;
import com.github.masterex.datus.DatusMapper;
import com.github.masterex.jmapper.JMapperMapper;
import com.github.masterex.mapstruct.MapStructShallowCopyMapper;
import com.github.masterex.models.SourceComplexObject;
import com.github.masterex.models.SourceSimpleListObject;
import com.github.masterex.models.SourceSimpleObject;
import com.github.masterex.models.TargetComplexObject;
import com.github.masterex.models.TargetSimpleListObject;
import com.github.masterex.models.TargetSimplePrimitiveObject;
import java.util.stream.IntStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComplexShallowDateAndListObjectMappingTest {

    static SourceComplexObject source;
    static TargetComplexObject target;
    static TargetSimpleListObject targetL;

    @BeforeClass
    public static void init() {
        source = ObjectFactory.getSourceComplexObject();
        target = ObjectFactory.getTargetComplexObject();
        targetL = ObjectFactory.getTargetSimpleListObject();
    }

    @Test
    public void beanCpTest() {
        Mapper mapper = new BeanCPMapper();
        testMap(mapper);
    }

    @Test
    public void beanUtilsTest() {
        Mapper mapper = new BeanUtilsMapper();
        testMap(mapper);
    }

    @Test
    public void jMapperTest() {
        Mapper mapper = new JMapperMapper();
        testMap(mapper);
    }

    @Test
    public void mapStructTest() {
        Mapper mapper = new MapStructShallowCopyMapper();
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

    private void testMap(Mapper mapper) {
        TargetComplexObject mappingTarget = mapper.convert(source);
        assertEquals(target, mappingTarget);
        assertNotSame(target, mappingTarget);
        assertTrue(source.getDate() == mappingTarget.getDate());
        assertTrue(source.getNumber() == mappingTarget.getNumber());
        
        TargetSimplePrimitiveObject targetPrimitive = mappingTarget.getSimpleObject();
        SourceSimpleObject sourceSimple = source.getSimpleObject();
        assertEquals(targetPrimitive.getField1(), sourceSimple.getField1().longValue());
        assertEquals(targetPrimitive.isField2(), sourceSimple.getField2());
        assertEquals(targetPrimitive.getField3(), sourceSimple.getField3());
        assertEquals(targetPrimitive.getField4(), sourceSimple.getField4().charValue());
        assertTrue(sourceSimple.getField5().equals(targetPrimitive.getField5()));
        
        
        TargetSimpleListObject targetList = mappingTarget.getListObject();
        SourceSimpleListObject sourceList = source.getListObject();
        
        assertEquals(targetList, targetL);
        assertNotSame(targetList, sourceList);
        assertTrue(sourceList.getList1() == targetList.getList1());
        assertTrue(sourceList.getList2() == targetList.getList2());
        assertTrue(sourceList.getList3() == targetList.getList3());
        assertTrue(sourceList.getList4() == targetList.getList4());
        assertTrue(sourceList.getList5() == targetList.getList5());
        IntStream.range(0, 1000)
                .forEach(i -> {
                    assertEquals(sourceList.getList1().get(i), targetList.getList1().get(i));
                    assertEquals(sourceList.getList2().get(i), targetList.getList2().get(i));
                    assertEquals(sourceList.getList3().get(i), targetList.getList3().get(i));
                    assertEquals(sourceList.getList4().get(i), targetList.getList4().get(i));
                    assertEquals(sourceList.getList5().get(i), targetList.getList5().get(i));

                    assertTrue(sourceList.getList1().get(i) == targetList.getList1().get(i));
                    assertTrue(sourceList.getList2().get(i) == targetList.getList2().get(i));
                    assertTrue(sourceList.getList3().get(i) == targetList.getList3().get(i));
                    assertTrue(sourceList.getList4().get(i) == targetList.getList4().get(i));
                    assertTrue(sourceList.getList5().get(i) == targetList.getList5().get(i));
                });
    }

}
