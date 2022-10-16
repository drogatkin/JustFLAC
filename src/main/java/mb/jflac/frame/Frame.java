package mb.jflac.frame;

import mb.jflac.Constants;

/**
 * The FLAC Frame class.
 * @author kc7bfi
 */
public class Frame {
    /** The frame header. */
    public Header header;
    
    /** The subframes - One per channel. */
    public Channel[] subframes = new Channel[Constants.MAX_CHANNELS];
    
    /** The frame footer. */
    private short crc;
    
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Frame Header: " + header + "\n");
        for (int i = 0; i < header.channels; i++) {
            sb.append("\tFrame Data " + subframes[i].toString() + "\n");
        }
        sb.append("\tFrame Footer: " + crc);
        
        return sb.toString();
        
    }
    
    /**
     * Return the maximum Rice partition order based on the block size.
     * @param blocksize The block size
     * @return  The maximum Rice partition order
     */
    public static int getMaxRicePartitionOrderFromBlocksize(int blocksize) {
        int maxRicePartitionOrder = 0;
        while ((blocksize & 1) == 0) {
            maxRicePartitionOrder++;
            blocksize >>= 1;
        }
        return Math.min(Constants.MAX_RICE_PARTITION_ORDER, maxRicePartitionOrder);
    }
    
    /**
     * return the frame's CRC.
     * @return Returns the crc.
     */
    public short getCRC() {
        return crc;
    }
    
    /**
     * Set the frame's CRC.
     * @param crc The crc to set.
     */
    public void setCRC(short crc) {
        this.crc = crc;
    }
}
