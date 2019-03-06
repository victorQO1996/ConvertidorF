package salon;


    import lombok.Data;

    @Data
    public class clase {

        private String salon;
        private String grupo;
        private String laboratorio;

        public clase(String salon, String grupo, String laboratorio) {
            this.salon = salon;
            this.grupo = grupo;
            this.laboratorio = laboratorio;
        }
    }

