package ar.edu.unju.fi.tp6.models;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name="CLIENTES")
@Component
public class Cliente {
	
	@Id
	@Column(name="CLI_id")
    private String tipoDocumento;
	
	@Column(name="CLI_nroDoc")
	private int nroDocumento;
	
	@Column(name="CLI_nombreApellido")
	private String nombreApellido;
	
	@Column(name="CLI_email")
	private String email;
	
	@Column(name="CLI_password")
	private String password;
	
	@Column(name="CLI_fechaNac")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	@Column(name="CLI_codTelf")
	private int codigoAreaTelefono;
	
	@Column(name="CLI_nroTelf")
	private int telefono;
	
	@Column(name="CLI_fechaCompra")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;


    public Cliente() {
    }

    public Cliente(String tipoDocumento, int nroDocumento, String nombreApellido, String email, String password, LocalDate fechaNacimiento, int codigoAreaTelefono, int telefono, LocalDate fechaUltimaCompra) {
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.nombreApellido = nombreApellido;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.codigoAreaTelefono = codigoAreaTelefono;
        this.telefono = telefono;
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNroDocumento() {
        return this.nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNombreApellido() {
        return this.nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCodigoAreaTelefono() {
        return this.codigoAreaTelefono;
    }

    public void setCodigoAreaTelefono(int codigoAreaTelefono) {
        this.codigoAreaTelefono = codigoAreaTelefono;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaUltimaCompra() {
        return this.fechaUltimaCompra;
    }

    public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    @Override
    public String toString() {
        return "{" +
            " tipoDocumento='" + getTipoDocumento() + "'" +
            ", nroDocumento='" + getNroDocumento() + "'" +
            ", nombreApellido='" + getNombreApellido() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", fechaNacimiento='" + getFechaNacimiento() + "'" +
            ", codigoAreaTelefono='" + getCodigoAreaTelefono() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", fechaUltimaCompra='" + getFechaUltimaCompra() + "'" +
            "}";
    }

    /**
	 * Método que calcula la edad en base a la fecha de nacimiento
	 * 
	 * @return Integer que es la cantidad de años
	 */
	public int getEdad() {
		int edad = 0;
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaNacimiento, hoy);
		edad = periodo.getYears();
		return edad;

	}

	/**
	 * método que calcula el tiempo que falta hasta el cumpleaños
	 * 
	 * @return un String que indica la cantidad de años, meses, dias, hora, min y
	 *         segundos
	 */
	public String tiempoHastaCumple() {
		String texto = "";
		LocalDate hoy = LocalDate.now();
		int anio;
		if (hoy.getMonthValue() <= this.fechaNacimiento.getMonthValue()) {
			if (hoy.getDayOfMonth() <= this.fechaNacimiento.getDayOfMonth()) {
				anio = hoy.getYear();
			} else {
				anio = hoy.getYear() + 1;
			}
		} else {
			anio = hoy.getYear() + 1;
		}
		LocalDate fechaProxCumple = LocalDate.of(anio, this.fechaNacimiento.getMonth(),
				this.fechaNacimiento.getDayOfMonth());
		Period periodo = Period.between(hoy, fechaProxCumple);
		texto = "Año:" + periodo.getYears() + " Mes:" + periodo.getMonths() + " Día:" + periodo.getDays();

		// LocalDateTime
		LocalDateTime ahora = LocalDateTime.now();
		LocalDateTime fechaHoraProxCumple = LocalDateTime.of(anio, this.fechaNacimiento.getMonth(),
				this.fechaNacimiento.getDayOfMonth(), 0, 0, 0);
		Duration duracion = Duration.between(ahora, fechaHoraProxCumple);
		texto = texto + " hora:" + duracion.toHours() + " min:" + duracion.toMinutes() + " seg:"
				+ duracion.toMillis()/1000;

		return texto;
	}

	/**
	 * Método que calcula el tiempo desde la ultima compra hasta el día de la fecha
	 * 
	 * @return String que es el tiempo "Año-Mes-Día"
	 */
	public String tiempoHastaUltimaCompra() {
		String texto = "";
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaUltimaCompra, hoy);
		texto = "Año:" + periodo.getYears() + " Mes:" + periodo.getMonths() + " día:" + periodo.getDays();
		return texto;
	}

	/**
	 * Método que calcula el tiempo transcurrido desde la fecha de nacimiento
	 * contado en días
	 * 
	 * @return String cantidad de días
	 */
	public String tiempoDesdeFechaNac() {
		LocalDate hoy = LocalDate.now();
		long numeros_de_dias = ChronoUnit.DAYS.between(fechaNacimiento, hoy);
		return String.valueOf(numeros_de_dias) + " días";
	}

}
