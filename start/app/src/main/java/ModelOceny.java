import android.widget.RadioGroup;

public class ModelOceny {
    private String nazwa;
    private String pozycja;
    private RadioGroup ocena;

    public ModelOceny()
    {
    }

    public ModelOceny(String _nazwa, String _pozycja,RadioGroup _ocena)
    {
        nazwa = _nazwa;
        ocena = _ocena;
        pozycja = _pozycja;
    }

    public RadioGroup getModelOcena()
    {
        return ocena;
    }
    public  void setModelOcena(String _nazwa, String _pozycja, RadioGroup _ocena)
    {
        nazwa = _nazwa;
        ocena = _ocena;
        pozycja = _pozycja;
    }
}
