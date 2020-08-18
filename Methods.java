// Sarthak Gupta
// 11/14/2019
// Includes all methods to find all of the genes in a strand of DNA 

public class Methods {
	// finds the gene in the DNA string by calling other methods
	public static String findGene(String DNA, int where) {
		String emptystring = "";

		int startIndex = DNA.indexOf("ATG", where);
		if (startIndex == -1) {
			return emptystring;
		}

		int TAAIndex = findStopCodon(DNA, startIndex, "TAA");
		int TAGIndex = findStopCodon(DNA, startIndex, "TAG");
		int TGAIndex = findStopCodon(DNA, startIndex, "TGA");
		int minIndex = Math.min(TAAIndex, Math.min(TAGIndex, TGAIndex));
		if (minIndex == DNA.length()) {
			return emptystring;
		}

		return DNA.substring(startIndex, minIndex + 3);
	}

	// finds the location of the first stop codon after a start codon
	// STOP CODONS: TAA, TAG, or TGA
	public static int findStopCodon(String dna, int startIndex, String stopCodon) {
		int currIndex = dna.indexOf(stopCodon, startIndex + 3);
		while (currIndex != -1) {
			int diff = currIndex - startIndex;
			if (diff % 3 == 0) {
				return currIndex;
			} else {
				currIndex = dna.indexOf(stopCodon, currIndex + 1);
			}
		}
		return dna.length();
	}

	// returns all of the genes found in a string of DNA
	public static String printAllGenes(String DNA) {
		int startIndex = 0;
		int numGenes = 0;
		String genes = "";
		while (true) {
			String currentGene = findGene(DNA, startIndex);
			if (currentGene.isEmpty()) {
				break;
			}
			genes += (currentGene + "\n");
			numGenes++;
			startIndex = DNA.indexOf(currentGene, startIndex) + currentGene.length();
		}
		// System.out.println("Total number of genes found: " + numGenes);
		return (genes + "\nTotal number of genes found: " + numGenes);
	}

	// counts the number of codons in the DNA string
	public static int countCodon(String DNA, String codon) {
		int count = 0;
		int startIndex = 0;
		if (startIndex == -1) {
			return -1;
		}
		while (true) {
			int codonIndex = DNA.indexOf(codon, startIndex + 3);
			if (codonIndex == -1) {
				break;
			}
			count++;
			startIndex = codonIndex + 3;
		}
		return count;
	}
}