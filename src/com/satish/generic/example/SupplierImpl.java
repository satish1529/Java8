package com.satish.generic.example;

import java.util.function.Supplier;

public class SupplierImpl implements Supplier<String> {

	@Override
	public String get() {
		return "test";
	}

}
