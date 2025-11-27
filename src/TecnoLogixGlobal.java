import javax.swing.JOptionPane;

public class TecnoLogixGlobal {
    public static void main(String[] args) {
        // Configuración Inicial del Día con confirmación
        String limiteStr = JOptionPane.showInputDialog(null, "Bienvenido a TecnoLogix Global\n\nIngrese el límite máximo de productos a registrar:", "Configuración Inicial - Paso 1", JOptionPane.QUESTION_MESSAGE);
        int limite = Integer.parseInt(limiteStr);
        while (limite <= 0) {
            JOptionPane.showMessageDialog(null, "❌ Error: El límite debe ser mayor a 0.\n\nPor favor, inténtelo de nuevo.", "Error en Configuración", JOptionPane.ERROR_MESSAGE);
            limiteStr = JOptionPane.showInputDialog(null, "Ingrese el límite máximo de productos a registrar:", "Configuración Inicial - Paso 1", JOptionPane.QUESTION_MESSAGE);
            limite = Integer.parseInt(limiteStr);
        }

        String diaStr = JOptionPane.showInputDialog(null, "Configuración Inicial - Paso 2\n\nIngrese el día de operación:\n1 = Lunes\n2 = Martes\n3 = Miércoles\n4 = Jueves\n5 = Viernes\n6 = Sábado\n7 = Domingo", "Configuración Inicial - Paso 2", JOptionPane.QUESTION_MESSAGE);
        int dia = Integer.parseInt(diaStr);
        while (dia < 1 || dia > 7) {
            JOptionPane.showMessageDialog(null, "❌ Error: Día inválido. Ingrese un número entre 1 y 7.\n\nPor favor, inténtelo de nuevo.", "Error en Configuración", JOptionPane.ERROR_MESSAGE);
            diaStr = JOptionPane.showInputDialog(null, "Ingrese el día de operación:\n1 = Lunes\n2 = Martes\n3 = Miércoles\n4 = Jueves\n5 = Viernes\n6 = Sábado\n7 = Domingo", "Configuración Inicial - Paso 2", JOptionPane.QUESTION_MESSAGE);
            dia = Integer.parseInt(diaStr);
        }

        // Confirmación para iniciar el registro
        int confirm = JOptionPane.showConfirmDialog(null, "✅ Configuración completada.\n\nDía: " + dia + "\nLímite de productos: " + limite + "\n\n¿Desea iniciar el registro de productos?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada. ¡Hasta luego!", "Salida", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Variables para acumuladores y reportes
        double totalIVA = 0;
        double totalIMC = 0;
        double totalIRT = 0;
        double totalTCE = 0;
        double totalMonto = 0;
        int countCat1 = 0;
        int countCat2 = 0;
        int countCat3 = 0;
        int countCat4 = 0;
        String maxProducto = "";
        double maxPrecio = 0;
        int totalProductos = 0;

        // Variables para el Desafío Extra 1: Ranking
        String productoMaxStock = "";
        int maxStock = 0;
        String productoMaxPrecio = "";
        double maxPrecioRanking = 0;

        // Bucle para registrar productos
        for (int i = 0; i < limite; i++) {
            String tituloProducto = "Registro del Producto " + (i + 1) + " de " + limite;

            // Ingreso y validación de datos con mensajes mejorados
            String nombre = JOptionPane.showInputDialog(null, "📦 " + tituloProducto + "\n\nNombre del producto:", tituloProducto, JOptionPane.QUESTION_MESSAGE);

            String precioBaseStr = JOptionPane.showInputDialog(null, "💰 " + tituloProducto + "\n\nPrecio base (debe ser mayor a 0):", tituloProducto, JOptionPane.QUESTION_MESSAGE);
            double precioBase = Double.parseDouble(precioBaseStr);
            while (precioBase <= 0) {
                JOptionPane.showMessageDialog(null, "❌ Error: El precio base debe ser mayor a 0.\n\nPor favor, inténtelo de nuevo.", "Error en Precio", JOptionPane.ERROR_MESSAGE);
                precioBaseStr = JOptionPane.showInputDialog(null, "Precio base (debe ser mayor a 0):", tituloProducto, JOptionPane.QUESTION_MESSAGE);
                precioBase = Double.parseDouble(precioBaseStr);
            }

            String categoriaStr = JOptionPane.showInputDialog(null, "🏷️ " + tituloProducto + "\n\nCategoría:\n1 = Electrónica personal\n2 = Componentes de cómputo\n3 = Accesorios (exentos de IVA)\n4 = Redes y telecomunicaciones", tituloProducto, JOptionPane.QUESTION_MESSAGE);
            int categoria = Integer.parseInt(categoriaStr);
            while (categoria < 1 || categoria > 4) {
                JOptionPane.showMessageDialog(null, "❌ Error: Categoría inválida. Ingrese 1, 2, 3 o 4.\n\nPor favor, inténtelo de nuevo.", "Error en Categoría", JOptionPane.ERROR_MESSAGE);
                categoriaStr = JOptionPane.showInputDialog(null, "Categoría:\n1 = Electrónica personal\n2 = Componentes de cómputo\n3 = Accesorios (exentos de IVA)\n4 = Redes y telecomunicaciones", tituloProducto, JOptionPane.QUESTION_MESSAGE);
                categoria = Integer.parseInt(categoriaStr);
            }

            String riesgoStr = JOptionPane.showInputDialog(null, "⚠️ " + tituloProducto + "\n\nRiesgo tecnológico:\n1 = Sí\n0 = No", tituloProducto, JOptionPane.QUESTION_MESSAGE);
            int riesgo = Integer.parseInt(riesgoStr);
            while (riesgo != 0 && riesgo != 1) {
                JOptionPane.showMessageDialog(null, "❌ Error: Riesgo inválido. Ingrese 0 o 1.\n\nPor favor, inténtelo de nuevo.", "Error en Riesgo", JOptionPane.ERROR_MESSAGE);
                riesgoStr = JOptionPane.showInputDialog(null, "Riesgo tecnológico:\n1 = Sí\n0 = No", tituloProducto, JOptionPane.QUESTION_MESSAGE);
                riesgo = Integer.parseInt(riesgoStr);
            }

            String stockStr = JOptionPane.showInputDialog(null, "📊 " + tituloProducto + "\n\nStock ingresado (mínimo 1):", tituloProducto, JOptionPane.QUESTION_MESSAGE);
            int stock = Integer.parseInt(stockStr);
            while (stock < 1) {
                JOptionPane.showMessageDialog(null, "❌ Error: El stock debe ser mínimo 1.\n\nPor favor, inténtelo de nuevo.", "Error en Stock", JOptionPane.ERROR_MESSAGE);
                stockStr = JOptionPane.showInputDialog(null, "Stock ingresado (mínimo 1):", tituloProducto, JOptionPane.QUESTION_MESSAGE);
                stock = Integer.parseInt(stockStr);
            }

            // Cálculos de impuestos
            double iva = (categoria != 3) ? 0.12 * precioBase : 0;
            double imc = 0.015 * precioBase;
            double irt = (riesgo == 1) ? 0.037 * precioBase : 0;
            double tce = (dia == 6 || dia == 7) ? 0.02 * precioBase : 0;
            double precioFinal = precioBase + iva + imc + irt + tce;

            // Reporte por Producto mejorado
            String nombreCategoria = "";
            if (categoria == 1) nombreCategoria = "Electrónica personal";
            else if (categoria == 2) nombreCategoria = "Componentes de cómputo";
            else if (categoria == 3) nombreCategoria = "Accesorios";
            else nombreCategoria = "Redes y telecomunicaciones";

            String reporteProducto = "📋 Reporte del Producto\n\n" +
                    "Nombre: " + nombre + "\n" +
                    "Precio base: $" + String.format("%.2f", precioBase) + "\n" +
                    "IVA aplicado: $" + String.format("%.2f", iva) + "\n" +
                    "IMC aplicado: $" + String.format("%.2f", imc) + "\n" +
                    "IRT aplicado: $" + String.format("%.2f", irt) + "\n" +
                    "TCE aplicado: $" + String.format("%.2f", tce) + "\n" +
                    "Precio final: $" + String.format("%.2f", precioFinal) + "\n" +
                    "Categoría: " + nombreCategoria + "\n" +
                    "Stock ingresado: " + stock + " unidades";
            JOptionPane.showMessageDialog(null, reporteProducto, "Reporte del Producto " + (i + 1), JOptionPane.INFORMATION_MESSAGE);

            // Acumuladores
            totalIVA += iva;
            totalIMC += imc;
            totalIRT += irt;
            totalTCE += tce;
            totalMonto += precioFinal;
            totalProductos++;

            // Contadores por categoría
            if (categoria == 1) countCat1++;
            else if (categoria == 2) countCat2++;
            else if (categoria == 3) countCat3++;
            else countCat4++;

            // Producto con mayor precio final (para reporte final)
            if (precioFinal > maxPrecio) {
                maxPrecio = precioFinal;
                maxProducto = nombre;
            }

            // Desafío Extra 1: Ranking - Actualizar máximo stock y máximo precio final
            if (stock > maxStock) {
                maxStock = stock;
                productoMaxStock = nombre;
            }
            if (precioFinal > maxPrecioRanking) {
                maxPrecioRanking = precioFinal;
                productoMaxPrecio = nombre;
            }
        }

        // Determinar categoría con mayor número de productos
        String categoriaMayor = "";
        int maxCount = countCat1;
        categoriaMayor = "Electrónica personal";
        if (countCat2 > maxCount) {
            maxCount = countCat2;
            categoriaMayor = "Componentes de cómputo";
        }
        if (countCat3 > maxCount) {
            maxCount = countCat3;
            categoriaMayor = "Accesorios";
        }
        if (countCat4 > maxCount) {
            maxCount = countCat4;
            categoriaMayor = "Redes y telecomunicaciones";
        }

        // Reporte Final del Día mejorado
        String reporteFinal = "📊 Reporte Final del Día\n\n" +
                "Total de productos registrados: " + totalProductos + "\n" +
                "Total recaudado en IVA: $" + String.format("%.2f", totalIVA) + "\n" +
                "Total recaudado en IMC: $" + String.format("%.2f", totalIMC) + "\n" +
                "Total recaudado en IRT: $" + String.format("%.2f", totalIRT) + "\n" +
                "Total recaudado en TCE: $" + String.format("%.2f", totalTCE) + "\n" +
                "Monto total acumulado de ventas: $" + String.format("%.2f", totalMonto) + "\n" +
                "Categoría con mayor número de productos: " + categoriaMayor + "\n" +
                "Producto con mayor precio final: " + maxProducto + " ($" + String.format("%.2f", maxPrecio) + ")\n\n" +
                "🏆 Desafío Extra 1: Ranking de Productos\n" +
                "Producto con mayor stock: " + productoMaxStock + " (" + maxStock + " unidades)\n" +
                "Producto con mayor precio final: " + productoMaxPrecio + " ($" + String.format("%.2f", maxPrecioRanking) + ")";
        JOptionPane.showMessageDialog(null, reporteFinal, "Reporte Final del Día - TecnoLogix Global", JOptionPane.INFORMATION_MESSAGE);

        // Mensaje de despedida
        JOptionPane.showMessageDialog(null, "✅ Operación completada exitosamente.\n\n¡Gracias por usar TecnoLogix Global!", "Fin del Día", JOptionPane.INFORMATION_MESSAGE);
    }
}
