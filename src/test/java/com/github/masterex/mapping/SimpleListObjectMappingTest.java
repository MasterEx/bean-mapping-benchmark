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
import com.github.masterex.dozer.DozerMapper;
import com.github.masterex.jmapper.JMapperMapper;
import static com.github.masterex.mapping.SimpleArrayObjectMappingTest.source;
import com.github.masterex.mapstruct.MapStructMapper;
import com.github.masterex.modelmapper.ModelMapperMapper;
import com.github.masterex.models.SourceSimpleListObject;
import com.github.masterex.models.TargetSimpleListObject;
import com.github.masterex.moo.MooMapper;
import com.github.masterex.nomin.NominMapper;
import com.github.masterex.orika.OrikaMapper;
import com.github.masterex.remap.RemapMapper;
import com.github.masterex.selma.SelmaMapper;
import java.util.stream.IntStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleListObjectMappingTest {

    static SourceSimpleListObject source;
    static TargetSimpleListObject target = new TargetSimpleListObject();

    @BeforeClass
    public static void init() {
        source = ObjectFactory.getSourceSimpleListObject();
        target = ObjectFactory.getTargetSimpleListObject();
    }

    @Test
    public void dozerTest() {
        Mapper mapper = new DozerMapper();
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

    @Test
    public void mooTest() {
        Mapper mapper = new MooMapper();
        testMap(mapper);
    }

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
    public void remapTest() {
        Mapper mapper = new RemapMapper();
        testMap(mapper);
    }

    private void testMap(Mapper mapper) {
        TargetSimpleListObject mappingTarget = mapper.convert(source);
        assertEquals(target, mappingTarget);
        assertNotSame(target, mappingTarget);
        assertNotSame(source.getList1(), mappingTarget.getList1());
        assertNotSame(source.getList2(), mappingTarget.getList2());
        assertNotSame(source.getList3(), mappingTarget.getList3());
        assertNotSame(source.getList4(), mappingTarget.getList4());
        assertNotSame(source.getList5(), mappingTarget.getList5());
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
