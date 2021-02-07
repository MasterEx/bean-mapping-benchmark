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
package com.github.masterex.mapstruct;

import com.github.masterex.JMHBenchmark;
import com.github.masterex.JMHState;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.Throughput)
@Timeout(time = 15, timeUnit = TimeUnit.SECONDS)
@Warmup(iterations = 2, time = 250, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(timeUnit = TimeUnit.SECONDS, time = 3)
@Fork(value = 1)
public class MapStructBenchmark implements JMHBenchmark {

    @Benchmark
    @Override
    public void testSimpleObjectMapping(JMHState state, Blackhole blackhole) {
        blackhole.consume(state.mapStructMapper.convert(state.source));
    }

    @Benchmark
    @Override
    public void testSimpleListObjectMapping(JMHState state, Blackhole blackhole) {
        blackhole.consume(state.mapStructMapper.convert(state.sourceList));
    }

    @Benchmark
    @Override
    public void testSimpleArrayObjectMapping(JMHState state, Blackhole blackhole) {
        blackhole.consume(state.mapStructMapper.convert(state.sourceArray));
    }

    @Benchmark
    @Override
    public void testComplexObjectMapping(JMHState state, Blackhole blackhole) {
        blackhole.consume(state.mapStructMapper.convert(state.sourceComplex));
    }

}
