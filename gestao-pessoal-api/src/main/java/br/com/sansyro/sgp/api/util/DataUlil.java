package br.com.sansyro.sgp.api.util;

import org.apache.commons.lang3.ObjectUtils;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Optional;

public class DataUlil {

	public static final int VALOR_ZERADO = 0;
    public static final long DIA_EM_MILESSEGUNDOS = 86400000L;
    public static final String FORMATO_DATA_PADRAO = "dd/MM/yyyy";

    public static final int QUANTIDADE_DIAS_EM_UMA_SEMANA = 7;
    public static final int QUANTIDADE_DIAS_EM_UMA_QUINZENA = 15;
    public static final int QUANTIDADE_DIAS_EM_UM_MES = 30;
    public static final int QUANTIDADE_DIAS_EM_UM_BIMESTRE = 60;
    public static final int QUANTIDADE_DIAS_EM_UM_TRIMESTRE = 90;
    public static final int QUANTIDADE_DIAS_EM_UM_QUADRIMESTRE = 120;
    public static final int QUANTIDADE_DIAS_EM_UM_SEMESTRE = 180;
    public static final int QUANTIDADE_DIAS_EM_UM_ANO = 365;
    
    /*public static final Map<Integer, Integer> MAPA_PERIODO_EM_DIAS = Collections.unmodifiableMap(new HashMap<Integer, Integer>
            () {
        {
            put(TipoPeriodoPlanejamentoBaseEnum.DIARIO.getId(), DataUtil.UM_DIA);
            put(TipoPeriodoPlanejamentoBaseEnum.SEMANAL.getId(), QUANTIDADE_DIAS_EM_UMA_SEMANA);
            put(TipoPeriodoPlanejamentoBaseEnum.QUINZENAL.getId(), QUANTIDADE_DIAS_EM_UMA_QUINZENA);
            put(TipoPeriodoPlanejamentoBaseEnum.MENSAL.getId(), QUANTIDADE_DIAS_EM_UM_MES);
            put(TipoPeriodoPlanejamentoBaseEnum.BIMESTRAL.getId(), QUANTIDADE_DIAS_EM_UM_BIMESTRE);
            put(TipoPeriodoPlanejamentoBaseEnum.TRIMESTRAL.getId(), QUANTIDADE_DIAS_EM_UM_TRIMESTRE);
            put(TipoPeriodoPlanejamentoBaseEnum.QUADRIMESTRAL.getId(), QUANTIDADE_DIAS_EM_UM_QUADRIMESTRE);
            put(TipoPeriodoPlanejamentoBaseEnum.SEMESTRAL.getId(), QUANTIDADE_DIAS_EM_UM_SEMESTRE);
            put(TipoPeriodoPlanejamentoBaseEnum.ANUAL.getId(), QUANTIDADE_DIAS_EM_UM_ANO);
        }
    });*/
    
    public static final int UM_ANO = 1;
    private static final int UM_DIA = 1;
    public static final Integer VALOR_MENOR = -1;
    public static final Integer VALOR_IGUAL = 0;
    public static final Integer VALOR_MAIOR = 1;
    public static final int HORA_23 = 23;
    public static final int MINUTO_59 = 59;
    public static final int SEGUNDO_59 = 59;
    public static final int MILISEGUNDO_999 = 999;

    public static Integer compararData(Date data1, Date data2, boolean ignorarHora) {
        Date dataInicio = ObjectUtils.clone(data1);
        Date dataFim = ObjectUtils.clone(data2);

        if (ignorarHora) {
            dataInicio = retornaDataHoraZerada(data1);
            dataFim = retornaDataHoraZerada(data2);
        }

        return dataInicio.compareTo(dataFim);
    }

    public static Date retornaDataHoraZerada(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.HOUR_OF_DAY, VALOR_ZERADO);
        c.set(Calendar.MINUTE, VALOR_ZERADO);
        c.set(Calendar.SECOND, VALOR_ZERADO);
        c.set(Calendar.MILLISECOND, VALOR_ZERADO);
        return c.getTime();
    }

    public static Date converteParaDate(LocalDate dataASerConvertida) {
        return Date.from(dataASerConvertida.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date converteParaDate(LocalDateTime dataASerConvertida) {
        return converteParaDate(dataASerConvertida.toLocalDate());
    }

    public static LocalDate converteDateParaLocalDate(Date dataASerConvertida) {
        Instant instant = Instant.ofEpochMilli(dataASerConvertida.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
    }

    public static Date retornaDataUmDiaAnterior(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - UM_DIA);
        return c.getTime();
    }

    public static Date retornarDataAnterior(Date data, int dias) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - dias);
        return c.getTime();
    }

    public static int obterAnoPosterior() {
        return Year.now().getValue() + UM_ANO;
    }

    public static Date somarDataDias(Date data, int soma) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(data);
        gc.add(Calendar.DAY_OF_MONTH, soma);
        return gc.getTime();
    }

    public static Date alterarMes(Date data, int meses) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(data);
        gc.add(Calendar.MONTH, meses);
        return gc.getTime();
    }

    public static Date retornarDataAtualOuPrimeiraDataAno(@NotNull Integer pAnoReferencia) {
        return Optional.of(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .filter(date -> pAnoReferencia.compareTo(Year.now().getValue()) <= VALOR_IGUAL)
                .orElse(Date.from(LocalDate.of(pAnoReferencia, Month.JANUARY, UM_DIA).atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    public static Date alterarAno(Date pDataAlterar, @NotNull Integer pAnoReferencia) {
        if (pDataAlterar == null) {
            return null;
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(pDataAlterar);
        gc.set(Calendar.YEAR, pAnoReferencia);
        return gc.getTime();
    }

    public static String formataData(Date data, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(data);
    }

    public static String formataDataPadrao(Date data) {
        return formataData(data, FORMATO_DATA_PADRAO);
    }

    public static int calcularDiferencaEntreDatas(Date dataInicial, Date dataFinal) {
        long diferencaEntreAsDatasEmMilessegundos = retornaDataHoraZerada(dataFinal).getTime() - retornaDataHoraZerada(dataInicial).getTime();
        Long diferencaEntreAsDatasEmDias = diferencaEntreAsDatasEmMilessegundos / DIA_EM_MILESSEGUNDOS;
        return diferencaEntreAsDatasEmDias.intValue();
    }

    public static int obterSemestreAtual() {
        Calendar dataAtual = Calendar.getInstance();
        int mes = dataAtual.get(Calendar.MONTH);

        if (mes < Calendar.JULY) {
            return 1;
        }
        return 2;
    }

    public static int obterAnoDaData(Date pData) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(pData);
        return gc.get(Calendar.YEAR);
    }

    public static Date obterDataUsandoHoraEDataSeparada(Date data, Date hora) {
        if (Objects.nonNull(data) && Objects.nonNull(hora)) {
            try {
                String horaAsStr = formataData(hora, "HH:mm:ss.SSS");
                String dataAsStr = formataData(data, "dd/MM/yyyy");
                return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").parse(dataAsStr + " " + horaAsStr);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static boolean verificarNovaDataMenorXDiasUteisDataAntiga(Date dataAntiga, Date novaData, int dias) {
        Date dataRetornada = retornarDataAnteriorUtil(novaData, dias);
        if (dataRetornada.compareTo(dataAntiga) <= 0) {
            return true;
        }

        return false;
    }

    public static Date retornarDataAnteriorUtil(Date data, int dias) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - dias);

        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - 1);
        } else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - 2);
        }

        return c.getTime();
    }
	
	public static String obterDataAtual() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}
	
	public static String obterDataHoraAtual() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	}
	
	public static String obterHoraAtual() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

	public static String obterDataFormatada(Date data) {
		return new SimpleDateFormat("dd/MM/yyyy").format(data);
	}
	
	public static String obterDataHoraFormatada(Date data) {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data);
	}
	
	public static String obterHoraFormatada(Date data) {
		return new SimpleDateFormat("HH:mm:ss").format(data);
	}

}

