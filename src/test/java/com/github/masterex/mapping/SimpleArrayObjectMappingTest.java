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
import com.github.masterex.dozer.DozerMapper;
import com.github.masterex.mapstruct.MapStructMapper;
import com.github.masterex.modelmapper.ModelMapperMapper;
import com.github.masterex.models.SourceSimpleArrayObject;
import com.github.masterex.models.TargetSimpleArrayObject;
import com.github.masterex.moo.MooMapper;
import com.github.masterex.nomin.NominMapper;
import com.github.masterex.orika.OrikaMapper;
import com.github.masterex.selma.SelmaMapper;
import java.util.stream.IntStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleArrayObjectMappingTest {

    static SourceSimpleArrayObject source;
    static TargetSimpleArrayObject target;

    @BeforeClass
    public static void init() {
        source = ObjectFactory.getSourceSimpleArrayObject();
        target = ObjectFactory.getTargetSimpleArrayObject();
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

    private void testMap(Mapper mapper) {
        TargetSimpleArrayObject mappingTarget = mapper.convert(source);
        assertEquals(target, mappingTarget);
        assertNotSame(target, mappingTarget);
        assertNotSame(source.getArray1(), mappingTarget.getArray1());
        assertNotSame(source.getArray2(), mappingTarget.getArray2());
        assertNotSame(source.getArray3(), mappingTarget.getArray3());
        assertNotSame(source.getArray4(), mappingTarget.getArray4());
        assertNotSame(source.getArray5(), mappingTarget.getArray5());
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
