package com.rapidfix;

import com.rapidfix.dto.FormatDto;
import com.rapidfix.dto.PhoneDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Map;
import java.util.Random;

@ApplicationScoped
public class FormatServices {

    private static final Map<String, String> DESCRIPTIONS = Map.ofEntries(
            Map.entry("socadito", "Carro en excelentes condiciones, como nuevo."),
            Map.entry("impecable", "Carro sin detalles, en perfectas condiciones."),
            Map.entry("pepita", "Vehículo destacado por su calidad o estado único."),
            Map.entry("nítido", "Automóvil en estado limpio y bien cuidado."),
            Map.entry("económico", "Vehículo con bajo consumo de combustible o precio accesible."),
            Map.entry("full_extras", "Incluye todas las comodidades y accesorios."),
            Map.entry("lujo", "Vehículo de alta gama con características premium."),
            Map.entry("garantizado", "Incluye garantía o respaldo del vendedor."),
            Map.entry("turbo", "Motor con mayor potencia gracias al sistema turbo."),
            Map.entry("seminuevo", "Carro usado pero en excelentes condiciones."),
            Map.entry("kilometraje_bajo", "Vehículo que ha recorrido pocos kilómetros."),
            Map.entry("casi_nuevo", "Automóvil con poco uso, en estado casi nuevo."),
            Map.entry("motor_potente", "Vehículo con motor fuerte y eficiente."),
            Map.entry("clásico", "Modelo icónico o con valor histórico."),
            Map.entry("de_agencia", "Vehículo comprado y mantenido directamente en la agencia."),
            Map.entry("recién_polarizado", "Vidrios polarizados recientemente."),
            Map.entry("todo_terreno", "Vehículo apto para caminos difíciles o aventuras."),
            Map.entry("familiares", "Automóvil ideal para viajes en familia."),
            Map.entry("confortable", "Vehículo con interior cómodo y buen diseño."),
            Map.entry("gasolina_eficiente", "Consumo reducido de combustible."),
            Map.entry("lista_para_viajar", "En condiciones para hacer viajes largos."),
            Map.entry("pintura_intacta", "Carro con pintura en perfecto estado."),
            Map.entry("mecánica_perfecta", "Sin problemas mecánicos; todo funciona."),
            Map.entry("ideal_para_trabajar", "Vehículo adecuado para uso comercial o laboral."),
            Map.entry("suspensión_suave", "Manejo cómodo gracias a una buena suspensión."),
            Map.entry("precio_negociable", "Posibilidad de acordar un precio más bajo."),
            Map.entry("modelo_único", "Versión especial o difícil de encontrar."),
            Map.entry("un_solo_dueño", "Vehículo previamente usado por una sola persona."),
            Map.entry("perfecto_para_la_ciudad", "Ideal para el tráfico y estacionamientos urbanos."),
            Map.entry("estilo_moderno", "Diseño contemporáneo y atractivo.")
    );

    public String formatText(FormatDto formatDto) {
        StringBuilder formattedText = new StringBuilder();

        // Eliminar caracteres innecesarios del texto
        String cleanedText = formatDto.getText()
                .replaceAll("[#_*]+", "") // Elimina #_, *, **, *** y similares
                .replaceAll("\\.\\.+", "") // Elimina .. y ...
                .strip();

        // Dividir el texto en líneas
        String[] lines = cleanedText.split("\n");

        // Agregar encabezado con emoji
        formattedText.append("🚗").append(lines[0].strip()).append("\n");

        // Línea adicional del texto
        formattedText.append(lines[1].strip()).append("\n");

        // Agregar una descripción aleatoria
        String randomDescription = getRandomDescription();
        formattedText.append(randomDescription).append("\n");

        // Encabezado de Características
        formattedText.append("✨Caracteristicas\n");

        // Características del texto (excluyendo líneas vacías y duplicadas)
        for (String line : lines) {
            if (!line.isBlank() && !line.equals(lines[0]) && !line.equals(lines[1])) {
                formattedText.append(line.strip()).append("\n");
            }
        }

        // Números de teléfono
        for (PhoneDto phone : formatDto.getPhone()) {
            formattedText.append(phone.getOperator().name())
                    .append(" ")
                    .append(phone.getPhone())
                    .append("\n");
        }

        return formattedText.toString().strip();
    }

    /**
     * Selecciona una descripción aleatoria del mapa de descripciones.
     *
     * @return Descripción aleatoria.
     */
    private String getRandomDescription() {
        List<String> values = DESCRIPTIONS.values().stream().toList();
        int randomIndex = new Random().nextInt(values.size());
        return values.get(randomIndex);
    }
}
