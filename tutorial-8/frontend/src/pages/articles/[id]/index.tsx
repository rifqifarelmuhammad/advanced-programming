import Head from 'next/head'
import Link from "next/link";
import {useRouter} from "next/router";
import {useState} from "react";

// type Article = {
//     id: number
//     author: string
//     title: string
//     content: string
//     timestamp: string
// }
//
// type Comment = {
//     id: number
//     postId: number
//     author: string
//     content: string
//     timestamp: string
// }

export default function ArticleDetail({ article, comments }) {
    const router = useRouter()
    const [isMutating, setIsMutating] = useState(false)
    async function handleDeleteArticle(){
        setIsMutating(true)

        await fetch(`http://localhost:8080/api/v1/article/delete-post/${article.id}`,{
            method: "DELETE"
        }).then((e) => {
            if (e.status == 200) {
                console.log(`Successfully deleted article with id ${article.id}`)
            }
        }).catch((e) => {
            console.log(e)
        }).finally(() => {
            setIsMutating(false)
            router.push("/articles")
        })
    }
    async function handleDeleteComment(id: number){
        console.log(id)

        await fetch(`http://localhost:8081/api/v1/comment/delete-comment/${id}`,{
            method: "DELETE"
        }).then((e) => {
            if (e.status == 200) {
                console.log(`Successfully deleted comment with id ${id}`)
            }
        }).catch((e) => {
            console.log(e)
        }).finally(() => {
            router.push(`/articles/${article.id}`)
        })
    }


    return (
        <div className="p-10 justify-center">
            <Head>
                <title>Article Detail</title>
            </Head>
            <div>
                <div className="prose lg:prose-xl py-2 mb-5">
                    <h1>Article Detail</h1>
                </div>
                <div className="container glass xl:rounded-box p-10 w-10/12">
                    <div className="card bg-base-100 shadow-xl mx-auto max-w-5xl prose lg:prose-xl">
                        <div className="card-body">
                            <div className="card-title flex-col items-start content-start">
                                <h2 className="!m-0">{article.title}</h2>
                                <h5 className="">by {article.author}</h5>
                            </div>
                            <h5 className="text-xs opacity-50">{article.timestamp}</h5>
                            <div className="divider !my-1"></div>
                            <p className="!mt-0">{article.content}</p>
                            <div className="card-actions justify-end items-end not-prose">
                                <div className="flex gap-3">
                                    {!isMutating ? (
                                        <button
                                            type="button"
                                            onClick={handleDeleteArticle}
                                            className="btn btn-error text-white">
                                            Delete
                                        </button>
                                    ) : (
                                        <button
                                            type="button"
                                            onClick={handleDeleteArticle}
                                            className="btn btn-error loading text-white">
                                            Delete
                                        </button>
                                    )}
                                    <button className="btn btn-primary">
                                        <Link href={`/articles/${article.id}/comment`}>Comment</Link>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br/>
                    <div className="container card bg-base-300/75 prose lg:prose-xl max-w-5xl p-7 bg-inherit/75">
                        <h3>Comments</h3>
                        {comments != null ? (
                            <div className="p-5">
                                {comments.map(comment => (
                                    <div className="card bg-zinc-600/50 shadow-xl mx-auto mb-3 max-w-5xl" key={comment.id}>
                                        <div className="card-body p-7">
                                            <div className="card-title flex-col items-start content-start">
                                                <h4 className="!m-0">{comment.author}</h4>
                                            </div>
                                            <p className="text-sm !mt-1">{comment.content}</p>
                                            <div className="card-actions justify-between items-end">
                                                <h5 className="text-xs opacity-50">{comment.timestamp}</h5>
                                                <div className="flex gap-3">
                                                    {!isMutating ? (
                                                        <button
                                                            type="button"
                                                            onClick={() => {
                                                                handleDeleteComment(comment.id)
                                                            }}
                                                            className="btn btn-sm btn-error text-white">
                                                            Delete
                                                        </button>
                                                    ) : (
                                                        <button
                                                            type="button"
                                                            onClick={() => {
                                                                handleDeleteComment(comment.id)
                                                            }}
                                                            className="btn btn-sm btn-error loading text-white">
                                                            Delete
                                                        </button>
                                                    )}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                ))}
                            </div>
                        ) : (
                            <div className="p-5 text-center">Unable to load comments</div>
                        )}
                    </div>
                </div>
            </div>
        </div>
    )
}

export async function getServerSideProps({params}: {params: {id: number}}) {
    const fetchArticle = await fetch(`http://localhost:8080/api/v1/article/get-post/${params.id}`, {
        cache: "no-store",
    })
    const dataArticle = await fetchArticle.json()

    let dataComments
    await fetch(`http://localhost:8081/api/v1/comment/get-all-comments/${params.id}`, {
        cache: "no-store",
    }).then(async (response) => {
        dataComments = await response.json()
    }).catch((e) => {
        dataComments = null
    })

    return {
        props: { article: dataArticle, comments: dataComments },
    }
}
