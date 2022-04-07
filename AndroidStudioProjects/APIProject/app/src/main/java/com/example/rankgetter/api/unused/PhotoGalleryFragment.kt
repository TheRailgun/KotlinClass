package com.example.rankgetter.api.unused
import androidx.fragment.app.Fragment
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory



class PhotoGalleryFragment : Fragment() {

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://na1.api.riotgames.com")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
}
    /*fun onFetch(){
        Log.e(TAG,"On Fetch Called")
        val flickrApi: FlickrApi = retrofit.create(FlickrApi::class.java)
        val flickrHomePageRequest: Call<String> = flickrApi.fetchData()
        flickrHomePageRequest.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "Failed to fetch photos", t)
            }
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                Log.d(TAG, "Response receivedPGF: ${response.body()}")
            }
        })
    }


        // val flickrLiveData: LiveData<String> = FlickrFetcher().fetchPhotos()
        val flickrLiveData: LiveData<List<GalleryItem>> = FlickrFetcher().fetchPhotos()
        flickrLiveData.observe(
            this,
            Observer { galleryItems->//responseString ->
                Log.d(TAG, "Response received: $galleryItems")//$responseString")
            })
        photoGalleryViewModel = ViewModelProvider(this).get(PhotoGalleryViewModel::class.java)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_photo_gallery, container, false)
        photoRecyclerView = view.findViewById(R.id.photo_recycler_view)
        photoRecyclerView.layoutManager = GridLayoutManager(context, 3)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoGalleryViewModel.galleryItemLiveData.observe(
            viewLifecycleOwner,
            {galleryItems->
                photoRecyclerView.adapter = PhotoAdapter(galleryItems)
            }

        )
    }
    private class PhotoHolder(private val itemImageView: ImageView):
    RecyclerView.ViewHolder(itemImageView){
        val bindDrawable: (Drawable) -> Unit = itemImageView::setImageDrawable
    }

    private inner class PhotoAdapter(private val galleryItems: List<GalleryItem>):
    RecyclerView.Adapter<PhotoHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
            val view = layoutInflater.inflate(R.layout.list_item_gallery, parent,false) as ImageView
            return PhotoHolder(view)
        }

        override fun getItemCount(): Int = galleryItems.size

        override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
            val galleryItem = galleryItems[position]
            val placeholder:Drawable= ContextCompat.getDrawable(
                requireContext(),
                R.drawable.iron
            )?:ColorDrawable()

            holder.bindDrawable(placeholder)
        }
    }


    companion object {
        fun newInstance() = PhotoGalleryFragment()
    }
}*/