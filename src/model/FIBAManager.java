package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import au.com.bytecode.opencsv.CSVReader;
import structures.*;

public class FIBAManager {
	
	private AVLTree<Double,ArrayList<Long>> ts;
    private AVLTree<Double,ArrayList<Long>> ftr;
    private AVLTree<Double,ArrayList<Long>> trb;
    private AVLTree<Double,ArrayList<Long>> orb;
    private BST<Double,ArrayList<Long>> blk;
    private File file;
    private String[] cell;
    
    public final static int TS = 0;
    public final static int FTR = 1;
    public final static int TRB = 2;
    public final static int ORB = 3;
    public final static int BLK = 4;
    

    public FIBAManager() {
        ts = new AVLTree<>();
        ftr = new AVLTree<>();
        trb = new AVLTree<>();
        orb = new AVLTree<>();
        blk = new BST<>();
    }

    public void readFiles(File file) throws IOException {
        this.file = file;
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        //RandomAccessFile raf = new RandomAccessFile(file, "r");

        br.readLine();

        long pos = 0;
        String temp = br.readLine();
        pos = 1;
        while (temp != null)
        	{
        	cell = temp.split(",");

            if (cell[7].equals("") == false) {
                if (!ts.keyExists(Double.parseDouble(cell[7]))) {
                    ts.add(Double.parseDouble(cell[7]), new ArrayList<Long>());
                }
                ts.search(Double.parseDouble(cell[7])).add(pos);

            }

            if (cell[9].equals("") == false) {

                if (ftr.keyExists(Double.parseDouble(cell[9]))) {
                    ftr.search(Double.parseDouble(cell[9])).add(pos);

                } else {
                    ftr.add(Double.parseDouble(cell[9]), new ArrayList<Long>());
                    ftr.search(Double.parseDouble(cell[9])).add(pos);

                }

            }

            if (cell[12].equals("") == false) {

                if (trb.keyExists(Double.parseDouble(cell[12]))) {
                    trb.search(Double.parseDouble(cell[12])).add(pos);

                } else {
                    trb.add(Double.parseDouble(cell[12]), new ArrayList<Long>());
                    trb.search(Double.parseDouble(cell[12])).add(pos);

                }

            }

            if (!cell[10].equals("")) {

                if (orb.keyExists(Double.parseDouble(cell[10]))) {
                    orb.search(Double.parseDouble(cell[10])).add(pos);

                } else {
                    orb.add(Double.parseDouble(cell[10]), new ArrayList<Long>());

                    orb.search(Double.parseDouble(cell[10])).add(pos);

                }
            }

            if (cell[15].equals("") == false) {

                if (blk.keyExists(Double.parseDouble(cell[15]))) {
                    blk.search(Double.parseDouble(cell[15])).add(pos);

                } else {
                    blk.add(Double.parseDouble(cell[15]), new ArrayList<Long>());
                    blk.search(Double.parseDouble(cell[15])).add(pos);

                }

            }
            //pos = raf.getFilePointer();
            pos++;
            temp = br.readLine();

        	}

        //raf.close();
        br.close();

    }
}
