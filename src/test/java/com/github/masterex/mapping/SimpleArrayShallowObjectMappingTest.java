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
import com.github.masterex.models.SourceSimpleArrayObject;
import com.github.masterex.models.TargetSimpleArrayObject;
import com.github.masterex.remap.RemapMapper;
import java.util.stream.IntStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleArrayShallowObjectMappingTest {

    static SourceSimpleArrayObject source;
    static TargetSimpleArrayObject target;

    @BeforeClass
    public static void init() {
        source = ObjectFactory.getSourceSimpleArrayObject();
        target = ObjectFactory.getTargetSimpleArrayObject();
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
    public void mapStructShalowTest() {
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

    @Test
    public void remapTest() {
        Mapper mapper = new RemapMapper();
        testMap(mapper);
    }

    private void testMap(Mapper mapper) {
        TargetSimpleArrayObject mappingTarget = mapper.convert(source);
        assertEquals(target, mappingTarget);
        assertNotSame(target, mappingTarget);
        assertTrue(source.getArray1() == mappingTarget.getArray1());
        assertTrue(source.getArray2() == mappingTarget.getArray2());
        assertTrue(source.getArray3() == mappingTarget.getArray3());
        assertTrue(source.getArray4() == mappingTarget.getArray4());
        assertTrue(source.getArray5() == mappingTarget.getArray5());
        IntStream.range(0, 1000)
                .forEach(i -> {
                    assertEquals(source.getArray1()[i], mappingTarget.getArray1()[i]);
                    assertEquals(source.getArray2()[i], mappingTarget.getArray2()[i]);
                    assertEquals(source.getArray3()[i], mappingTarget.getArray3()[i]);
                    assertEquals(source.getArray4()[i], mappingTarget.getArray4()[i]);
                    assertEquals(source.getArray5()[i], mappingTarget.getArray5()[i]);

                    assertTrue(source.getArray1()[i] == mappingTarget.getArray1()[i]);
                    assertTrue(source.getArray2()[i] == mappingTarget.getArray2()[i]);
                    assertTrue(source.getArray3()[i] == mappingTarget.getArray3()[i]);
                    assertTrue(source.getArray4()[i] == mappingTarget.getArray4()[i]);
                    assertTrue(source.getArray5()[i] == mappingTarget.getArray5()[i]);
                });
    }

}
