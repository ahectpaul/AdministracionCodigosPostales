void main() {
    String archivoCsv = "codigos_postales_hmo.csv";
    // TreeMap para ordenar por CP
    Map<String, Integer> conteoAsentamientos = new TreeMap<>();

    // 1. Leer el archivo CSV
    try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
        String linea;
        while ((linea = br.readLine()) != null) {

            // Separaré con comas
            String[] columnas = linea.split(",");

            if (columnas.length > 0) {
                String codigoPostal = columnas[0].trim();

                // 2. Almacenar y procesar los datos
                // IF CP ya existe, ++; else inicia en 1
                conteoAsentamientos.put(codigoPostal, conteoAsentamientos.getOrDefault(codigoPostal, 0) + 1);
            }
        }
    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
    }

    // 3. Mostrar los resultados
    System.out.println("--- Reporte de Asentamientos por Código Postal ---");
    for (Map.Entry<String, Integer> entrada : conteoAsentamientos.entrySet()) {
        System.out.println("Código postal: " + entrada.getKey() + " - Número de asentamientos: " + entrada.getValue());
    }
}