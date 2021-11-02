package cn.my.chapter_1.analysis_of_algorithm.three_sum;

import java.util.Objects;

public enum DataSetEnum {
	_1K(path("1Kints.txt"), 1000), _1M(path("1Mints.txt"), 1000000), _2K(path("2Kints.txt"), 2000),
	_4K(path("4Kints.txt"), 4000), _8K(path("8Kints.txt"), 8000), _16K(path("16Kints.txt"), 16000),
	_32K(path("32Kints.txt"), 32000);

	private static String path(String path) {
		return Objects.requireNonNull(DataSetEnum.class.getClassLoader().getResource(path)).getPath();
	}

	private final String path;

	private final int n;

	private DataSetEnum(String path, int n) {
		this.path = path;
		this.n = n;
	}

	public String getPath() {
		return path;
	}

	public int getN() {
		return n;
	}
}
