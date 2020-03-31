/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.configuration.hibernate.jpa;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;
import org.hibernate.Session;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MutipleDataSourceJavaService {

    private Session sessionField;
    private final Session session;

    public MutipleDataSourceJavaService(@CurrentSession Session session) {
        this.session = session;
    }

    @Inject
    public void setSessionField(@CurrentSession Session sessionField) {
        this.sessionField = sessionField;
    }

    @Transactional
    public boolean testCurrent() {
        session.clear();
        return true;
    }

    @Transactional
    public boolean testCurrentFromField() {
        sessionField.clear();
        return true;
    }

}