
package task2;

public class Shark {
    String name;
    String latinName;
    int Length = 0;
    int Depth = 0;
    String BirthFemale;
    int globalPresence = 0;
    String oceanicRegions;
    
    
    Shark(String name, String latinName, int Length, int Depth, String BirthFemale, int globalPresence, String oceanicRegions){
        this.name = name;
        this.latinName = latinName;
        this.Length = Length;
        this.Depth = Depth;
        this.BirthFemale = BirthFemale;
        this.globalPresence = globalPresence;
        this.oceanicRegions = oceanicRegions;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public int getLength() {
        return Length;
    }

    public void setLength(int Length) {
        this.Length = Length;
    }

    public int getDepth() {
        return Depth;
    }

    public void setDepth(int Depth) {
        this.Depth = Depth;
    }

    public String getBirthFemale() {
        return BirthFemale;
    }

    public void setBirthFemale(String BirthFemale) {
        this.BirthFemale = BirthFemale;
    }

    public int getGlobalPresence() {
        return globalPresence;
    }

    public void setGlobalPresence(int globalPresence) {
        this.globalPresence = globalPresence;
    }

    public String getOceanicRegions() {
        return oceanicRegions;
    }

    public void setOceanicRegions(String oceanicRegions) {
        this.oceanicRegions = oceanicRegions;
    }

    @Override
    public String toString() {
        return "-> " + this.name + ":" + this.latinName + ":" + this.Length + ":" + this.Depth + ":" 
            + this.BirthFemale + ":" + this.globalPresence + ":" + this.oceanicRegions;
    }
   
}
 

 

