package com.cronutils.model.time.generator;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.FieldExpression;
import com.cronutils.model.field.On;
import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.constraint.FieldConstraintsBuilder;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/*
 * Copyright 2015 jmrozanec
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class OnDayOfWeekValueGeneratorTest {

    private OnDayOfWeekValueGenerator fieldValueGenerator;

    private int year = 2015;
    private int month = 2;

    @Before
    public void setUp(){
        FieldConstraints constraints = FieldConstraintsBuilder.instance().createConstraintsInstance();
        fieldValueGenerator = new OnDayOfWeekValueGenerator(new CronField(CronFieldName.DAY_OF_WEEK, new On(constraints, "3")), year, month);
    }

    @Test
    public void testMatchesFieldExpressionClass() throws Exception {
        assertTrue(fieldValueGenerator.matchesFieldExpressionClass(mock(On.class)));
        assertFalse(fieldValueGenerator.matchesFieldExpressionClass(mock(FieldExpression.class)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNotMatchesOnDayOfWeekValueGenerator() throws Exception {
        new OnDayOfWeekValueGenerator(new CronField(CronFieldName.YEAR, mock(FieldExpression.class)), year, month);
    }
}