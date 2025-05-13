public class ProcessorFactory {
    /**
     * Возвращает нужный процессор в зависимости от варианта.
     * @param variant 1 — поиск палиндромов, 2 — удаление анаграмм.
     * @param text входной текст.
     */
    public static Processor createProcessor(int variant, String text) {
        switch (variant) {
            case 1:
                return new PalindromeProcessor(text);
            case 2:
                return new AnagramRemovalProcessor(text);
            default:
                throw new IllegalArgumentException("Неверный вариант: " + variant);
        }
    }
}
