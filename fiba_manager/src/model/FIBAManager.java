package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import au.com.bytecode.opencsv.CSVReader;
import structures.*;

public class FIBAManager {
	/*" "Points","Rebounds","Assists","Robberies","Blocks" "
	*/
	
	private AVLTree<Double,ArrayList<Long>> points;
    private AVLTree<Double,ArrayList<Long>> rebounds;
    private AVLTree<Double,ArrayList<Long>> assists;
    private AVLTree<Double,ArrayList<Long>> robberies;
    private BST<Double,ArrayList<Long>> blocks;
    private File file;
    private String[] cell;
    
    public final static int PTS = 0;
    public final static int RBS = 1;
    public final static int ASSIS = 2;
    public final static int ROBB = 3;
    public final static int BLK = 4;
    

    public FIBAManager() {
        points = new AVLTree<>();
        rebounds = new AVLTree<>();
        assists = new AVLTree<>();
        robberies = new AVLTree<>();
        blocks = new BST<>();
    }
    
    public ArrayList<String> search(int tree, double p) throws IOException {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Long> position = new ArrayList<Long>();
        
        switch(tree) {
        case PTS:
            position = points.search(p);
            break;
            
        case RBS:
            position = rebounds.search(p);
            break;
            
        case ASSIS:
            position = assists.search(p);
            break;
            
        case ROBB:
            position = robberies.search(p);
            break;
            
        case BLK:
        	position = blocks.search(p);
        	break;
        }

        if (position != null) {
        	
        	CSVReader reader = new CSVReader(new FileReader(file));
        	Collections.sort(position);
            ArrayList<String[]> aux = (ArrayList<String[]>)reader.readAll();
            for (int i = 0; i < position.size(); i++) {
            	String a = Arrays.toString(aux.get(position.get(i).intValue()));
            	a.replace("[", "");
            	a.replace("]", "");
            	result.add(a);
 
            }
            
        }

        return result;
    }
    
    public boolean removeBytsFile(double p) throws IOException {

        String paramRemove = Double.toString(p);

        File tempFile = new File("myTempFile.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine = reader.readLine();

        while ((currentLine) != null) {
            String trimmedLine = currentLine.trim();

            String[] cell = trimmedLine.split(",");

            String temp = reader.readLine();

            if (!cell[7].equals(paramRemove)) {
                if (temp == null) {
                    writer.write(currentLine);
                } else {

                    writer.write(currentLine + "\n");
                }
            }

        }

        reader.close();
        writer.close();
        boolean val = tempFile.renameTo(file);

        readFiles(this.file);
        return val;

    }

    public void removeByts(double p) throws IOException {

       removeBytsFile(p);

       ArrayList<String> result = new ArrayList<>();
        ArrayList<Long> position;
        position = points.search(p);

        if (position.size() != 0) {
            RandomAccessFile raf = new RandomAccessFile(file, "r");

            for (int i = 0; i < position.size(); i++) {
                raf.seek(position.get(i));
                result.remove(raf.readLine());

            }
            raf.close();
        }
    }
    
    public ArrayList<String> searchByRange(int tree, double start, double end) throws IOException {
    	ArrayList<String> result = new ArrayList<String>();
    	
    	LinkedList<ArrayList<Long>> positions = new LinkedList<>();
    	
    	switch(tree) {
        case PTS:
            positions = points.searchByRange(start,end);
            break;
            
        case RBS:
            positions = rebounds.searchByRange(start,end);
            break;
            
        case ASSIS:
            positions = assists.searchByRange(start,end);
            break;
            
        case ROBB:
            positions = robberies.searchByRange(start,end);
            break;
            
        case BLK:
        	positions = blocks.searchByRange(start,end);
        	break;
        }
    	
    	if (!positions.isEmpty()) {
    		
    		CSVReader reader = new CSVReader(new FileReader(file));
    		ArrayList<String[]> aux = (ArrayList<String[]>)reader.readAll();
    		
    		for(ArrayList<Long> pos:positions) {
        		
        		for (int i = 0; i < pos.size(); i++) {
        			String a = Arrays.toString(aux.get(pos.get(i).intValue()));
        			a.replace("[", "");
        			a.replace("]", "");
        			result.add(a);
        		}
    		}

    	}
    	
    	return result;
    }
    
    public void readFiles(File file) throws IOException {
        this.file = file;
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        br.readLine();

        long pos = 0;
        String temp = br.readLine();
        pos = 1;
        while (temp != null)
        	{
        	cell = temp.split(",");

            if (cell[7].equals("") == false) {
                if (!points.keyExists(Double.parseDouble(cell[7]))) {
                    points.add(Double.parseDouble(cell[7]), new ArrayList<Long>());
                }
                points.search(Double.parseDouble(cell[7])).add(pos);

            }

            if (cell[9].equals("") == false) {

                if (rebounds.keyExists(Double.parseDouble(cell[9]))) {
                    rebounds.search(Double.parseDouble(cell[9])).add(pos);

                } else {
                    rebounds.add(Double.parseDouble(cell[9]), new ArrayList<Long>());
                    rebounds.search(Double.parseDouble(cell[9])).add(pos);

                }

            }

            if (cell[12].equals("") == false) {

                if (assists.keyExists(Double.parseDouble(cell[12]))) {
                    assists.search(Double.parseDouble(cell[12])).add(pos);

                } else {
                    assists.add(Double.parseDouble(cell[12]), new ArrayList<Long>());
                    assists.search(Double.parseDouble(cell[12])).add(pos);

                }

            }

            if (!cell[10].equals("")) {

                if (robberies.keyExists(Double.parseDouble(cell[10]))) {
                    robberies.search(Double.parseDouble(cell[10])).add(pos);

                } else {
                    robberies.add(Double.parseDouble(cell[10]), new ArrayList<Long>());

                    robberies.search(Double.parseDouble(cell[10])).add(pos);

                }
            }

            if (cell[15].equals("") == false) {

                if (blocks.keyExists(Double.parseDouble(cell[15]))) {
                    blocks.search(Double.parseDouble(cell[15])).add(pos);

                } else {
                    blocks.add(Double.parseDouble(cell[15]), new ArrayList<Long>());
                    blocks.search(Double.parseDouble(cell[15])).add(pos);

                }

            }
            pos++;
            temp = br.readLine();

        	}
        br.close();
    }
    
    public AVLTree<Double, ArrayList<Long>> getTs() {
		return points;
	}

	public void setTs(AVLTree<Double, ArrayList<Long>> ts) {
		this.points = ts;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String[] getCell() {
		return cell;
	}

	public void setCell(String[] cell) {
		this.cell = cell;
	}

	

	public void setFtr(AVLTree<Double, ArrayList<Long>> ftr) {
		this.rebounds = ftr;
	}

	public void setTrb(AVLTree<Double, ArrayList<Long>> trb) {
		this.assists = trb;
	}

	public void setOrb(AVLTree<Double, ArrayList<Long>> orb) {
		this.robberies = orb;
	}

	public void setBlk(BST<Double, ArrayList<Long>> blk) {
		this.blocks = blk;
	}
	
	public  AVLTree<Double, ArrayList<Long>> getFtr() {
		return rebounds;
	}

	public  AVLTree<Double, ArrayList<Long>> getTrb() {
		return assists;
	}

	public  AVLTree<Double, ArrayList<Long>> getOrb() {
		return robberies;
	}

	public BST<Double, ArrayList<Long>> getBlk() {
		return blocks;
	}

}
