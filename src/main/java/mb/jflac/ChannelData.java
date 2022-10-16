package mb.jflac;

import mb.jflac.frame.EntropyPartitionedRiceContents;

/**
 * FLAC channel data.
 * This class holds the data for the channels in a FLAC frame.
 * @author kc7bfi
 */
public class ChannelData {
    /** The output signal. */
    private int[] output;
    
    /** the risidual signal. */
    private int[] residual;
    
    /** The Entropy signal. */
    private EntropyPartitionedRiceContents partitionedRiceContents;
    
    /**
     * The default constructor.
     * @param size  The block size
     */
    public ChannelData(final int size) {
        output = new int[size];
        residual = new int[size];
        partitionedRiceContents = new EntropyPartitionedRiceContents();
    }
    
    /**
     * @return Returns the output.
     */
    public int[] getOutput() {
        return output;
    }
    
    /**
     * @return Returns the partitionedRiceContents.
     */
    public EntropyPartitionedRiceContents getPartitionedRiceContents() {
        return partitionedRiceContents;
    }
    
    /**
     * @return Returns the residual.
     */
    public int[] getResidual() {
        return residual;
    }
}
