/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sourceforge.appgen.generator;

import java.io.File;

import net.sourceforge.appgen.model.Entity;
import net.sourceforge.appgen.model.GenerationInformation;
import net.sourceforge.appgen.model.MethodInvocationInfoInterceptor;
import net.sourceforge.appgen.util.ConventionUtils;

/**
 * @author Byeongkil Woo
 */
public class MethodInvocationInfoInterceptorFileGenerator extends OnceFileGenerator {

	public static final String TEMPLATE = "methodInvocationInfoInterceptor.vm";
	
	public MethodInvocationInfoInterceptorFileGenerator(GenerationInformation generationInformation) {
		super(generationInformation);
	}
	
	@Override
	public File getFile(Entity entity) {
		MethodInvocationInfoInterceptor methodInvocationInfoInterceptor = new MethodInvocationInfoInterceptor(packageName);
		
		return new File(getDirectory(), methodInvocationInfoInterceptor.getClassName() + ".java");
	}

	@Override
	public File getDirectory() {
		MethodInvocationInfoInterceptor methodInvocationInfoInterceptor = new MethodInvocationInfoInterceptor(packageName);
		
		return new File(outputDir.getPath() + File.separator + "src" + File.separator + ConventionUtils.getPath(methodInvocationInfoInterceptor.getFullPackageName()));
	}

	@Override
	public String getTemplate() {
		return TEMPLATE;
	}
	
}
