package br.com.caixavidaeprevidencia.desafio.caixa.util.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.function.Function;

public class Amount {

	private static final int DEFAULT_SCALE = 2;
	private static final int DEFAULT_PRECISION = 15;
	private static final RoundingMode DEFAULF_ROUNDING_MODE = RoundingMode.HALF_UP;
	public static final Amount ZERO = Amount.valueOf(0.0);
	public static final Amount CEM = Amount.valueOf(100.0);
	private int scale;
	private int precision;
	private RoundingMode roundingMode;
	private final MathContext mc;
	private final Optional<BigDecimal> value;
	private BigDecimal defaultValue;

	Amount(Number value, int scale, int precision, RoundingMode roundingMode, BigDecimal defaultValue) {
		super();
		this.scale = scale;
		this.precision = precision;
		this.roundingMode = roundingMode;
		this.mc = new MathContext(this.precision, this.roundingMode);
		this.value = Optional.ofNullable(value).map(toBigDecial());
		this.defaultValue = defaultValue;

	}

	private Function<Number, BigDecimal> toBigDecial() {
		return new Function<Number, BigDecimal>() {
			@Override
			public BigDecimal apply(Number input) {
				return new BigDecimal(input.toString());
			}
		};
	}

	public static Amount fromNullable(Number value) {
		return new Amount(value, DEFAULT_SCALE, DEFAULT_PRECISION, DEFAULF_ROUNDING_MODE, BigDecimal.ZERO);
	}

	public BigDecimal value() {
		return this.value.orElse(defaultValue);
	}

	public static Amount valueOf(double value) {
		return fromNullable(value);
	}

}