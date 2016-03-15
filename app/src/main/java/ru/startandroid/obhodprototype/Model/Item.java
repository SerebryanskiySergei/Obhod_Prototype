package ru.startandroid.obhodprototype.Model;

public class Item {
    public int Id;
    public int Title;
    public Parameter[] Params;

    private class Parameter{
        public ParameterTypes Type;
        public String Name;
        private String Value;


        public String getValue(){
            return Value;
        }

        public void setValue(int value){
            Type = ParameterTypes.INTEGER;
            Value = String.valueOf(value);
        }
        public void setValue(String value){
            Type = ParameterTypes.STRING;
            Value = value;
        }
        public void setValue(boolean value){
            Type = ParameterTypes.BOOLEAN;
            Value = String.valueOf(value);
        }
    }
    public enum ParameterTypes{INTEGER, STRING, BOOLEAN}

}
