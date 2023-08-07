import java.util.List;

public class Main {
    public static void main(String[] args) {

        MaterialDefinition mat1Definition = new MaterialDefinition();
        mat1Definition.addProperty(new MaterialDefinitionProperty("Weight", "1000 kg"));
        mat1Definition.addProperty(new MaterialDefinitionProperty("Strength", "100 Pa"));

        MaterialDefinition mat2Definition = new MaterialDefinition();
        mat2Definition.addProperty(new MaterialDefinitionProperty("Weight", "2000 kg"));
        mat2Definition.addProperty(new MaterialDefinitionProperty("Strength", "200 Pa"));

        MaterialClass mat1Class = new MaterialClass();
        mat1Class.addProperty(new MaterialClassProperty("Name", "Material-1"));
        mat1Class.addProperty(new MaterialClassProperty("Type", "Copper"));

        MaterialClass mat2Class = new MaterialClass();
        mat2Class.addProperty(new MaterialClassProperty("Name", "Material-2"));
        mat2Class.addProperty(new MaterialClassProperty("Type", "Aluminium"));

        MaterialLot mat1Lot = new MaterialLot(mat1Definition);
        MaterialLot mat2Lot = new MaterialLot(mat2Definition);

        MaterialSublot mat1Sublot1 = new MaterialSublot();
        MaterialSublot mat1Sublot2 = new MaterialSublot();
        mat1Lot.addIsMadeUpOf(mat1Sublot1);
        mat1Lot.addIsMadeUpOf(mat1Sublot2);

        MaterialSublot mat2Sublot1 = new MaterialSublot();
        MaterialSublot mat2Sublot2 = new MaterialSublot();
        mat2Lot.addIsMadeUpOf(mat2Sublot1);
        mat2Lot.addIsMadeUpOf(mat2Sublot2);

        System.out.println("Material Definition Properties:");
        List<MaterialDefinitionProperty> mat1DefinitionProperties = mat1Definition.getProperties();
        for (int i = 0; i < mat1DefinitionProperties.size(); i++) {
            MaterialDefinitionProperty property = mat1DefinitionProperties.get(i);
            System.out.println("MAT1 - " + property.getName() + ": " + property.getValue());
        }

        List<MaterialDefinitionProperty> mat2DefinitionProperties = mat2Definition.getProperties();
        for (int i = 0; i < mat2DefinitionProperties.size(); i++) {
            MaterialDefinitionProperty property = mat2DefinitionProperties.get(i);
            System.out.println("MAT2 - " + property.getName() + ": " + property.getValue());
        }

        System.out.println("\nMaterial Class Properties:");
        List<MaterialClassProperty> mat1ClassProperties = mat1Class.getProperties();
        for (int i = 0; i < mat1ClassProperties.size(); i++) {
            MaterialClassProperty property = mat1ClassProperties.get(i);
            System.out.println("MAT1 - " + property.getName() + ": " + property.getDescription());
        }

        List<MaterialClassProperty> mat2ClassProperties = mat2Class.getProperties();
        for (int i = 0; i < mat2ClassProperties.size(); i++) {
            MaterialClassProperty property = mat2ClassProperties.get(i);
            System.out.println("MAT2 - " + property.getName() + ": " + property.getDescription());
        }

        System.out.println("\nMaterial Lot Properties:");
        System.out.println("MAT1 - Defined by Material Definition");
        System.out.println("MAT2 - Defined by Material Definition");


        System.out.println("\nMaterial Sublot Properties:");
        List<MaterialSublot> mat1Sublots = mat1Lot.getIsMadeUpOf();
        for (int i = 0; i < mat1Sublots.size(); i++) {
            MaterialSublot sublot = mat1Sublots.get(i);
            System.out.println("MAT1 - Assembled from Material Sublot " + (i + 1));
        }

        List<MaterialSublot> mat2Sublots = mat2Lot.getIsMadeUpOf();
        for (int i = 0; i < mat2Sublots.size(); i++) {
            MaterialSublot sublot = mat2Sublots.get(i);
            System.out.println("MAT2 - Assembled from Material Sublot " + (i + 1));
        }
    }
}