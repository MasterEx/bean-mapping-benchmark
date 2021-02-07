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
import com.github.masterex.models.SourceSimpleListObject;
import com.github.masterex.models.TargetSimpleListObject;
import java.util.stream.IntStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleListShallowObjectMappingTest {

    static SourceSimpleListObject source;
    static TargetSimpleListObject target = new TargetSimpleListObject();

    @BeforeClass
    public static void init() {
        source = ObjectFactory.getSourceSimpleListObject();
        target = ObjectFactory.getTargetSimpleListObject();
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
        TargetSimpleListObject mappingTarget = mapper.convert(source);
        assertEquals(target, mappingTarget);
        assertNotSame(target, mappingTarget);
        assertTrue(source.getList1() == mappingTarget.getList1());
        assertTrue(source.getList2() == mappingTarget.getList2());
        assertTrue(source.getList3() == mappingTarget.getList3());
        assertTrue(source.getList4() == mappingTarget.getList4());
        assertTrue(source.getList5() == mappingTarget.getList5());
        IntStream.range(0, 1000)
                .forEach(i -> {
                    assertEquals(source.getList1().get(i), mappingTarget.getList1().get(i));
                    assertEquals(source.getList2().get(i), mappingTarget.getList2().get(i));
                    assertEquals(source.getList3().get(i), mappingTarget.getList3().get(i));
                    assertEquals(source.getList4().get(i), mappingTarget.getList4().get(i));
                    assertEquals(source.getList5().get(i), mappingTarget.getList5().get(i));

                    assertTrue(source.getList1().get(i) == mappingTarget.getList1().get(i));
                    assertTrue(source.getList2().get(i) == mappingTarget.getList2().get(i));
                    assertTrue(source.getList3().get(i) == mappingTarget.getList3().get(i));
                    assertTrue(source.getList4().get(i) == mappingTarget.getList4().get(i));
                    assertTrue(source.getList5().get(i) == mappingTarget.getList5().get(i));
                });
    }

}
