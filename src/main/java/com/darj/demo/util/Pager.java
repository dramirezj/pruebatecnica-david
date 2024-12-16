package com.darj.demo.util;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Pager<T> {

	private final List<T> records;
    private final Long totalSize;
	
}
