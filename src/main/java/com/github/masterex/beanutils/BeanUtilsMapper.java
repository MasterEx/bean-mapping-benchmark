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
package com.github.masterex.beanutils;

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
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.Converter;

public class BeanUtilsMapper implements Mapper {

    private final BeanUtilsMapper self;

    public BeanUtilsMapper() {
        self = this;
    }

    @Override
    public TargetSimplePrimitiveObject convert(SourceSimplePrimitiveObject object) {
        TargetSimplePrimitiveObject target = new TargetSimplePrimitiveObject();
        try {
            BeanUtils.copyProperties(target, object);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(BeanUtilsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return target;
    }

    @Override
    public TargetSimpleListObject convert(SourceSimpleListObject object) {
        TargetSimpleListObject target = new TargetSimpleListObject();
        try {
            BeanUtils.copyProperties(target, object);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(BeanUtilsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return target;
    }

    @Override
    public TargetSimpleArrayObject convert(SourceSimpleArrayObject object) {
        TargetSimpleArrayObject target = new TargetSimpleArrayObject();
        try {
            BeanUtils.copyProperties(target, object);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(BeanUtilsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return target;
    }

    @Override
    public TargetComplexObject convert(SourceComplexObject object) {
        TargetComplexObject target = new TargetComplexObject();
        try {
            BeanUtilsBean.getInstance().getConvertUtils().register(new Converter() {
                @Override
                public <T> T convert(Class<T> type, Object o) {
                    return (T) self.convert((SourceSimpleObject) o);
                }

            }, TargetSimplePrimitiveObject.class);

            BeanUtilsBean.getInstance().getConvertUtils().register(new Converter() {
                @Override
                public <T> T convert(Class<T> type, Object o) {
                    return (T) self.convert((SourceSimpleListObject) o);
                }

            }, TargetSimpleListObject.class);
            BeanUtils.copyProperties(target, object);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(BeanUtilsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return target;
    }

    public TargetSimplePrimitiveObject convert(SourceSimpleObject object) {
        TargetSimplePrimitiveObject target = new TargetSimplePrimitiveObject();
        try {
            BeanUtils.copyProperties(target, object);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(BeanUtilsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return target;
    }

    @Override
    public SourceSimpleObject fromSimpleObjectToSimpleOject(SourceSimpleObject object) {
        SourceSimpleObject target = new SourceSimpleObject();
        try {
            BeanUtils.copyProperties(target, object);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(BeanUtilsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return target;
    }

    @Override
    public TargetComplexObject2 convert(SourceComplexObject2 object) {
        TargetComplexObject2 target = new TargetComplexObject2();
        try {
            BeanUtils.copyProperties(target, object);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(BeanUtilsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return target;
    }

}
