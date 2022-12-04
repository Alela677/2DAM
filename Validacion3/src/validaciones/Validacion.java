package validaciones;

public class Validacion {

	// Validaciones
	private static final String[] TITULO = { "Dr.", "Sr.", "Sra." };
	private static final String NOMBRE = "([A-Z]{1}[a-z]+[ ]?{1}){1,3}";
	private static final String APELLIDOS = "([A-Z]{1}[a-z]+[ ]?{1}){1,2}";
	private static final String TELEFONO = "[6|7|8|9]{1}[0-9]{8}";
	private static final String CP = "^[0-9]{5}(?:-[0-9]{4})?$";
	private static final String EMAIL = "^[a-zA-Z0-9_\\\\-]+@[a-zA-Z0-9]+\\.[a-z]{2,4}";
	private static final String URL = "(https?://[A-Za-z0-9-]+(.[A-Za-z-])*(/[A-Za-z_\\-]*|(\\.\\.?))+)?";

	// Valida el titulo de la persona
	public static String titulo(String titu) {
		System.out.println("----------Comprobaciones----------");
		if (!titu.isEmpty()) {
			for (String string : TITULO) {
				if (titu.equals(string)) {

					System.out.println("TITULO VALIDO: " + titu);

					return titu;
				}
			}
		} else {
			System.out.println("EL CAMPO TITULO ESTA VACIO");
		}
		System.out.println("ERROR: LINEA 1 EL TITULO NO TIENE EL FORMATO ADECUADO O ESTA VACIO");
		return null;
	}

	// Valida el nombre de la persona
	public static String nombre(String nombre) {

		if (nombre.length() <= 50) {
			if (nombre.matches(NOMBRE) == true) {
				System.out.println("NOMBRE VALIDO: " + nombre);
				return nombre;
			} else {
				System.out.println("ERROR: EL FORMATO DE NOMBRE NO ES CORRECTO");
			}
		} else {
			System.out.println("EL TAMAÑO DEL NOMBRE SUPERO LOS 50 CARACTERES");
		}

		return null;

	}

	// Valida los apellidos de la persona
	public static String apellidos(String apellidos) {

		if (!apellidos.isEmpty()) {

			if (apellidos.length() <= 100) {

				if (apellidos.matches(APELLIDOS)) {
					System.out.println("APELLIDO VALIDO: " + apellidos);
					return apellidos;

				} else {
					System.out.println("ERROR: LINEA 3 EL FOMATO NO ES CORRECTO");

				}
			} else {
				System.out.println("EL TAMAÑO DE LOS APELLIDOS SUPERO LOS 100 CARACTERES");
			}

		} else {
			System.out.println("ERROR: EL APELLIDO ESTA VACIO");
		}

		return null;
	}

	// Valida el telefono de la persona
	public static String telefono(String telefono) {

		if (!telefono.isEmpty()) {
			if (telefono.length() == 9) {
				if (telefono.matches(TELEFONO)) {
					System.out.println("TELEFONO VALIDO: " + telefono);
				} else {
					System.out.println("ERROR: LINEA 4 EL FORMATO DEL TELEFONO ES INCORRECTO");
				}
			} else {
				System.out.println("EL NUMERO CONTIENE  MAS O MENOS DE 9 CARACTERES");
			}

		} else {
			System.out.println("EL TELEFONO ESTA VACIO");
		}
		return null;
	}
	
	// Valida el codigo postal de la persona
	public static String codigoPostal(String cp) {

		if (!cp.isEmpty()) {
			if (cp.length() == 5) {
				if (cp.matches(CP)) {
					System.out.println("CODIGO POSTAL VALIDO: " + cp);
					return cp;
				} else {
					System.out.println("ERROR: LINEA 5 EL FORMATO DEL CODIGO POSTAL EL INCORRECTO");
				}
			} else {
				System.out.println("EL CODIGO POSTAL CONTIENE MAS O MENOS DE 5 CARACTERES");
			}
		} else {
			System.out.println("EL CAMPO CODIGO POSTAL ESTA VACIO");
		}
		return null;

	}

	// Valida el email de la persona
	public static String email(String email) {

		if (!email.isEmpty()) {
			if (email.matches(EMAIL)) {
				System.out.println("EMAIL VALIDO: " + email);
				return email;
			} else {
				System.out.println("ERROR: LINEA 6 EL FORMATO DEL EMAIL EL INCORRECTO");
			}
		} else {
			System.out.println("EL CAMPO EMAIL ESAT VACIO");
		}

		return null;
	}
	
	// Valida la url de la persona
	public static String url(String url) {

		if (!url.isEmpty()) {
			if (url.matches(URL)) {
				System.out.println("URL VALIDO: " + url);
				return url;
			} else {
				System.out.println("ERROR: LINEA 7 EL FORMATO DE LA URL ES INCORRECTA");
			}
		}
		return null;

	}
}
